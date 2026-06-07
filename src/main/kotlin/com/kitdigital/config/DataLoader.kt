package com.kitdigital.config

import com.kitdigital.model.Project
import com.kitdigital.model.ProjectStatus
import com.kitdigital.repository.ProjectRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader {
    @Bean
    fun loadData(repo: ProjectRepository) = CommandLineRunner {
        listOf(
            Project(name = "Web Corporativa PYME", clientName = "Ferreteria Lopez SL", status = ProjectStatus.COMPLETED, budget = 2500.0, kitDigitalCode = "KD-2024-001", description = "WordPress. 100% aceptacion."),
            Project(name = "Tienda Online", clientName = "Boutique Raquel", status = ProjectStatus.IN_PROGRESS, budget = 3800.0, kitDigitalCode = "KD-2024-002", description = "E-commerce WooCommerce"),
            Project(name = "CRM API Integration", clientName = "Fontaneria Garcia", status = ProjectStatus.COMPLETED, budget = 4200.0, kitDigitalCode = "KD-2024-003", description = "REST API. -15% procesamiento")
        ).forEach { repo.save(it) }
    }
}
