package com.kitdigital.controller

import com.kitdigital.model.Project
import com.kitdigital.model.ProjectStatus
import com.kitdigital.service.ProjectService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = ["*"])
class ProjectController(private val svc: ProjectService) {
    @GetMapping fun getAll(): List<Project> = svc.findAll()
    @GetMapping("/{id}") fun getById(@PathVariable id: Long): Project = svc.findById(id)
    @GetMapping("/status/{status}") fun getByStatus(@PathVariable status: ProjectStatus): List<Project> = svc.findByStatus(status)
    @GetMapping("/kpi") fun kpi(): Map<String, Any> = svc.getKpiSummary()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) fun create(@RequestBody p: Project): Project = svc.create(p)
    @PutMapping("/{id}") fun update(@PathVariable id: Long, @RequestBody p: Project): Project = svc.update(id, p)
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) fun delete(@PathVariable id: Long) = svc.delete(id)
}
