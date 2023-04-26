package com.github.music_api.endpoint

import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ZeroCopyHttpOutputMessage
import org.springframework.http.codec.multipart.FilePart
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths

@RestController
@RequestMapping("/files")
class UploadDownloadController {
    @GetMapping("/download/{fileName}")
    @Throws(IOException::class)
    fun downloadFile(
            @PathVariable fileName: String,
            response: ServerHttpResponse
    ): Mono<Void> {
        val zeroCopyResponse = response as ZeroCopyHttpOutputMessage
        response.getHeaders()[HttpHeaders.CONTENT_DISPOSITION] =
                "attachment; filename=$fileName"
        response.getHeaders().contentType = MediaType.APPLICATION_OCTET_STREAM
        val resource = ClassPathResource("files/$fileName")
        val file = resource.file
        return zeroCopyResponse.writeWith(
                file, 0,
                file.length()
        )
    }

    private val basePath: Path = Paths.get("./src/main/resources/files/")

    @PostMapping("/single/upload")
    fun uploadFile(@RequestPart("file") filePartMono: Mono<FilePart>): Mono<Void> {
        return filePartMono.doOnNext {
                    println("Received file: ${it.filename()}")
                }.flatMap {
                    it.transferTo(basePath.resolve(it.filename()))
                }.then()
    }

    @PostMapping("/multi/upload")
    fun uploadFiles(@RequestPart("files") filePartFlux: Flux<FilePart>): Mono<Void> {
        return filePartFlux.doOnNext {
                    println(it.filename())
                }.flatMap {
                    it.transferTo(basePath.resolve(it.filename()))
                }.then()
    }
}