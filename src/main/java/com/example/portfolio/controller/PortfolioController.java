package com.example.portfolio.controller;

import com.example.portfolio.model.Project;
import com.example.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // GET all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return portfolioService.getAllProjects();
    }

    // GET project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
        return portfolioService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Add new project
    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return portfolioService.addProject(project);
    }

    // PUT - Update project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id,
                                                  @RequestBody Project project) {
        return portfolioService.updateProject(id, project)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Remove project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        if (portfolioService.deleteProject(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}