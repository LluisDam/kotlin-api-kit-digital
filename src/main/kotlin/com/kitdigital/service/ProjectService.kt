package com.kitdigital.service

import com.kitdigital.model.Project
import com.kitdigital.model.ProjectStatus
import com.kitdigital.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class ProjectService(private val repo: ProjectRepository) {
    fun findAll(): List<Project> = repo.findAll()
    fun findById(id: Long): Project = repo.findById(id).orElseThrow { NoSuchElementException("Project $id not found") }
    fun findByStatus(status: ProjectStatus): List<Project> = repo.findByStatus(status)
    fun create(p: Project): Project = repo.save(p)
    fun update(id: Long, p: Project): Project { findById(id); return repo.save(p.copy(id = id)) }
    fun delete(id: Long) { findById(id); repo.deleteById(id) }
    fun getKpiSummary(): Map<String, Any> {
        val all = findAll()
        val done = all.count { it.status == ProjectStatus.COMPLETED }
        return mapOf("total" to all.size, "completed" to done, "inProgress" to all.count { it.status == ProjectStatus.IN_PROGRESS }, "completionRate" to if (all.isEmpty()) 0.0 else done.toDouble() / all.size * 100, "totalBudget" to all.sumOf { it.budget })
    }
}
