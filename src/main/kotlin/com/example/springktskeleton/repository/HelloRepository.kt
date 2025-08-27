package com.example.springktskeleton.repository

import com.example.springktskeleton.entity.HelloEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HelloRepository : JpaRepository<HelloEntity, Long>
