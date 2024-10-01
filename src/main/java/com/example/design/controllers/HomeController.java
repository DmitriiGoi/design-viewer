package com.example.design.controllers;

import com.example.design.domain.Project;
import com.example.design.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String main(Model model) {
        return "home";
    }

    @GetMapping("/design")
    public String design(Model model) {
        return "design";
    }

    @GetMapping("/design/{projectName}")
    public String projectDesign(@PathVariable String projectName, Model model) {
        Project project = projectService.getAllProjects().stream().filter(t -> t.getName().equals(projectName)).findFirst().get();
        model.addAttribute("projectId", project.getId());
        return "project";
    }

    @GetMapping("/champions")
    public String champions(Model model) {
        return "champions";
    }
}
