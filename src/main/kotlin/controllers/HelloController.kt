package com.example.springktskeleton.controllers

import com.example.springktskeleton.resources.HelloRessource
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController : HelloRessource {

    override fun hello(name: String?) =
        "Hello, ${name ?: "World"}!"

    override fun secure(token: String?) =
        if (token == "secret") "✅ Access granted"
        else "⛔ Unauthorized"
}
