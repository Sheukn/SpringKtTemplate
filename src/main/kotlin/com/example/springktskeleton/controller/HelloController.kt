package com.example.springktskeleton.controller

import com.example.springktskeleton.dto.HelloDto
import com.example.springktskeleton.service.HelloService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hello")
class HelloController(private val helloService: HelloService) {
    
    @GetMapping
    fun getAllHellos(): ResponseEntity<List<HelloDto>> {
        val hellos = helloService.findAll()
        return ResponseEntity.ok(hellos)
    }
    
    @GetMapping("/{id}")
    fun getHelloById(@PathVariable id: Long): ResponseEntity<HelloDto> {
        return try {
            val hello = helloService.findById(id)
            ResponseEntity.ok(hello)
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
    
    @PostMapping
    fun createHello(@RequestBody dto: HelloDto): ResponseEntity<HelloDto> {
        val created = helloService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }
    
    @PutMapping("/{id}")
    fun updateHello(@PathVariable id: Long, @RequestBody dto: HelloDto): ResponseEntity<HelloDto> {
        return try {
            val updated = helloService.update(id, dto)
            ResponseEntity.ok(updated)
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
    
    @DeleteMapping("/{id}")
    fun deleteHello(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            helloService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
}
