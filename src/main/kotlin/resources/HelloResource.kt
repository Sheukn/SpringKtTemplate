package com.example.springktskeleton.resources

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

interface HelloRessource {

    @GetMapping("/hello")
    fun hello(@RequestParam name: String? = null): String

    @GetMapping("/secure")
    fun secure(@RequestHeader("X-Auth", required = false) token: String?): String
}
