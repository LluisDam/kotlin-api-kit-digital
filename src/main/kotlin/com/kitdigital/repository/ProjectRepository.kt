package com.kitdigital.repository

import com.kitdigital.model.Project
import com.kitdigital.model.ProjectStatus
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {
    fun findByStatus(status: ProjectStatus): List<Project>
    fun findByClientNameContainingIgnoreCase(name: String): List<Project>
}
