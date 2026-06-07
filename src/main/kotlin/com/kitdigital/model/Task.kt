package com.kitdigital.model

import jakarta.persistence.*

enum class TaskStatus { TODO, IN_PROGRESS, DONE }
enum class TaskPriority { LOW, MEDIUM, HIGH }

@Entity
@Table(name = "tasks")
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false) val project: Project,
    @Column(nullable = false) val title: String,
    val description: String = "",
    @Enumerated(EnumType.STRING) val status: TaskStatus = TaskStatus.TODO,
    @Enumerated(EnumType.STRING) val priority: TaskPriority = TaskPriority.MEDIUM,
    @Column(name = "estimated_hours") val estimatedHours: Int = 0,
    @Column(name = "logged_hours") val loggedHours: Int = 0
)
