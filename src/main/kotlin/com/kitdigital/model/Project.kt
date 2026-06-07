package com.kitdigital.model

import jakarta.persistence.*
import java.time.LocalDate

enum class ProjectStatus { PENDING, IN_PROGRESS, COMPLETED, CANCELLED }

@Entity
@Table(name = "projects")
data class Project(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(nullable = false) val name: String,
    val description: String = "",
    @Column(name = "client_name", nullable = false) val clientName: String,
    @Enumerated(EnumType.STRING) val status: ProjectStatus = ProjectStatus.PENDING,
    val budget: Double = 0.0,
    @Column(name = "start_date") val startDate: LocalDate = LocalDate.now(),
    @Column(name = "end_date") val endDate: LocalDate? = null,
    @Column(name = "kit_digital_code") val kitDigitalCode: String = ""
)
