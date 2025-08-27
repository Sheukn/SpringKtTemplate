package com.springktskeleton.mapper

import com.springktskeleton.dto.UserDto
import com.springktskeleton.entity.UserEntity
import org.springframework.stereotype.Component

/**
 * Mapper for converting between UserEntity and UserDto
 * Good practice for separation of concerns and maintainability
 */
@Component
class UserMapper {

    /**
     * Convert UserEntity to UserDto
     */
    fun toDto(entity: UserEntity): UserDto {
        return UserDto(
            id = entity.id,
            username = entity.username,
            email = entity.email
        )
    }

    /**
     * Convert UserDto to UserEntity
     * Note: Password is not included in DTO for security reasons
     */
    fun toEntity(dto: UserDto): UserEntity {
        return UserEntity(
            id = dto.id,
            username = dto.username,
            email = dto.email,
            password = "" // Password should be handled separately for security
        )
    }

    /**
     * Convert list of UserEntity to list of UserDto
     */
    fun toDtoList(entities: List<UserEntity>): List<UserDto> {
        return entities.map { toDto(it) }
    }

    /**
     * Update existing entity with data from DTO
     * Useful for PATCH operations
     * Note: Password is preserved from existing entity
     */
    fun updateEntityFromDto(entity: UserEntity, dto: UserDto): UserEntity {
        entity.username = dto.username
        entity.email = dto.email
        // Keep existing password - password updates should be handled separately
        return entity
    }
}
