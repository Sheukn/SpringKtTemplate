package com.springktskeleton.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.springktskeleton.entity.UserEntity

@Repository
interface UserRepository : JpaRepository<UserEntity, Long>
