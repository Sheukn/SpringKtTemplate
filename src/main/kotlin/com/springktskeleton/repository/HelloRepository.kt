package com.springktskeleton.repository

import com.springktskeleton.entity.HelloEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HelloRepository : JpaRepository<HelloEntity, Long>
