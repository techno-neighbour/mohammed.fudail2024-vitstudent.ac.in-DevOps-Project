package com.example.portfolio.model;

public class Project {

    private int id;
    private String title;
    private String category;
    private String description;
    private String techStack;
    private String liveUrl;

    // Constructor
    public Project(int id, String title, String category,
                   String description, String techStack, String liveUrl) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.techStack = techStack;
        this.liveUrl = liveUrl;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTechStack() { return techStack; }
    public void setTechStack(String techStack) { this.techStack = techStack; }

    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }

}