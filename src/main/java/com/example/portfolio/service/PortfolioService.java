package com.example.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.portfolio.model.Project;

@Service
public class PortfolioService {

    private List<Project> projects = new ArrayList<>();
    private int idCounter = 1;

    // Pre-load some sample projects
    public PortfolioService() {
        projects.add(new Project(idCounter++, "E-Commerce Website",
                "Web Development",
                "A full-stack online shopping platform with cart and payment integration.",
                "HTML, CSS, JavaScript, Spring Boot",
                "http://localhost:8083/projects"));

        projects.add(new Project(idCounter++, "Portfolio Dashboard",
                "UI Design",
                "A responsive personal portfolio dashboard with dark mode support.",
                "HTML, CSS, Bootstrap",
                "http://localhost:8083/projects"));

        projects.add(new Project(idCounter++, "Task Manager App",
                "Web Application",
                "A task management app with CRUD operations and priority tracking.",
                "Spring Boot, REST API, Maven",
                "http://localhost:8083/projects"));
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projects;
    }

    // Get project by ID
    public Optional<Project> getProjectById(int id) {
        return projects.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    // Add a new project
    public Project addProject(Project project) {
        project.setId(idCounter++);
        projects.add(project);
        return project;
    }

    // Update an existing project
    public Optional<Project> updateProject(int id, Project updated) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                updated.setId(id);
                projects.set(i, updated);
                return Optional.of(updated);
            }
        }
        return Optional.empty();
    }

    // Delete a project
    public boolean deleteProject(int id) {
        return projects.removeIf(p -> p.getId() == id);
    }

}