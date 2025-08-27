package com.springktskeleton.service

import org.springframework.stereotype.Service
import com.springktskeleton.repository.UserRepository
import com.springktskeleton.entity.UserEntity
import com.springktskeleton.dto.UserDto

@Service
class UserService(private val repository: UserRepository) {

    fun findAll(): List<UserDto> = repository.findAll().map { it.toDto() }

    fun findById(id: Long): UserDto = repository.findById(id)
        .orElseThrow { NoSuchElementException("User with id $id not found") }
        .toDto()

    fun create(dto: UserDto): UserDto = repository.save(dto.toEntity()).toDto()

    fun update(id: Long, dto: UserDto): UserDto {
        val existing = repository.findById(id)
            .orElseThrow { NoSuchElementException("User with id $id not found") }
        existing.username = dto.username
        existing.email = dto.email
        return repository.save(existing).toDto()
    }

    fun delete(id: Long) {
        if (!repository.existsById(id)) {
            throw NoSuchElementException("User with id $id not found")
        }
        repository.deleteById(id)
    }

    private fun UserEntity.toDto() = UserDto(
        id = this.id,
        username = this.username,
        email = this.email
    )

    private fun UserDto.toEntity() = UserEntity().apply {
        id = this@toEntity.id
        username = this@toEntity.username
        email = this@toEntity.email
    }
}
