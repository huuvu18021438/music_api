//package com.github.music_api.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
//import org.springframework.security.config.web.server.ServerHttpSecurity
//import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.web.server.SecurityWebFilterChain
//
//
//@Configuration
//@EnableWebFluxSecurity
//@EnableReactiveMethodSecurity
//class SecurityConfiguration {
//    @Bean
//    open fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
//        return http.authorizeExchange()
//                .pathMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//                .anyExchange().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .csrf().disable()
//                .build()
//    }
//
//    @Bean
//    fun userDetailService(): MapReactiveUserDetailsService {
//        val user: UserDetails = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER")
//                .build()
//
//        val admin: UserDetails = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("password"))
//                .roles("ADMIN")
//                .build()
//
//        return MapReactiveUserDetailsService(user, admin)
//    }
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//    }
//}