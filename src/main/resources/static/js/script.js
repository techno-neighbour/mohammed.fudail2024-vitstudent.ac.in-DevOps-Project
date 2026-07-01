const API_URL = "http://localhost:8083/projects";

// ========================== 
// LOAD ALL PROJECTS
// ==========================
async function loadProjects() {
    try {
        const response = await fetch(API_URL);
        const projects = await response.json();
        const grid = document.getElementById("project-grid");
        grid.innerHTML = "";

        projects.forEach(project => {
            const card = document.createElement("div");
            card.className = "project-card";
            card.innerHTML = `
                <h3>${project.title}</h3>
                <div class="category">${project.category}</div>
                <p>${project.description}</p>
                <div class="tech">Tech: ${project.techStack}</div>
                <button class="delete-btn" 
                    onclick="deleteProject(${project.id})">Delete</button>
            `;
            grid.appendChild(card);
        });

    } catch (error) {
        console.error("Error loading projects:", error);
    }
}

// ==========================
// ADD PROJECT
// ==========================
async function addProject() {
    const title       = document.getElementById("title").value.trim();
    const category    = document.getElementById("category").value.trim();
    const techStack   = document.getElementById("techStack").value.trim();
    const description = document.getElementById("description").value.trim();
    const liveUrl     = document.getElementById("liveUrl").value.trim();

    if (!title || !category || !techStack || !description) {
        alert("Please fill in all required fields.");
        return;
    }

    const project = { title, category, techStack, description, liveUrl };

    try {
        await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(project)
        });

        // Clear form fields
        document.getElementById("title").value = "";
        document.getElementById("category").value = "";
        document.getElementById("techStack").value = "";
        document.getElementById("description").value = "";
        document.getElementById("liveUrl").value = "";

        loadProjects();

    } catch (error) {
        console.error("Error adding project:", error);
    }
}

// ==========================
// DELETE PROJECT
// ==========================
async function deleteProject(id) {
    try {
        await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        loadProjects();
    } catch (error) {
        console.error("Error deleting project:", error);
    }
}

// ==========================
// LOAD ON PAGE START
// ==========================
document.addEventListener("DOMContentLoaded", loadProjects);