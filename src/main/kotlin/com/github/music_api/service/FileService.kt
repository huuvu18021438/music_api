package com.github.music_api.service

//import com.github.music_api.model.MusicFile
//import com.github.music_api.repository.FileRepository
//import org.springframework.http.codec.multipart.FilePart
//import org.springframework.stereotype.Service
//import org.springframework.util.StringUtils
//import org.springframework.web.multipart.MultipartFile
//import reactor.core.publisher.Mono
//
//@Service
//class FileService(private val fileRepository: FileRepository) {
//    fun saveMusicFile(file: FilePart): Mono<MusicFile> {
//        val fileName = StringUtils.cleanPath(file.filename())
//        return try {
//            if (fileName.contains("..")) {
//                throw Exception("Filename contains invalid path sequence $fileName")
//            }
//            val musicFile = MusicFile(fileName, "Binary", file.)
//            fileRepository.save(musicFile)
//        } catch (e: Exception) {
//            throw Exception("Could not save File: $fileName")
//        }
//    }
//}