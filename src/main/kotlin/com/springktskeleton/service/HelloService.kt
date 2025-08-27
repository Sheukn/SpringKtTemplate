package com.springktskeleton.service

import com.springktskeleton.dto.HelloDto
import com.springktskeleton.entity.HelloEntity
import com.springktskeleton.repository.HelloRepository
import org.springframework.stereotype.Service

@Service
class HelloService(private val repository: HelloRepository) {
    
    fun findAll(): List<HelloDto> = repository.findAll().map { it.toDto() }
    
    fun findById(id: Long): HelloDto = repository.findById(id)
        .orElseThrow { NoSuchElementException("Hello with id $id not found") }
        .toDto()
    
    fun create(dto: HelloDto): HelloDto = repository.save(dto.toEntity()).toDto()
    
    fun update(id: Long, dto: HelloDto): HelloDto {
        val existing = repository.findById(id)
            .orElseThrow { NoSuchElementException("Hello with id $id not found") }
        val updated = existing.copy(name = dto.name)
        return repository.save(updated).toDto()
    }
    
    fun delete(id: Long) {
        if (!repository.existsById(id)) {
            throw NoSuchElementException("Hello with id $id not found")
        }
        repository.deleteById(id)
    }
    
    // Simple mapping extensions
    private fun HelloEntity.toDto() = HelloDto(id = this.id, name = this.name)
    private fun HelloDto.toEntity() = HelloEntity(id = this.id, name = this.name)
}
