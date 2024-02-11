package com.vm189.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        System.out.println("Workinggg!!!!!");
        return "home";
    }

    @GetMapping("/course/{course_id}")
    public String getCourseDetails(@PathVariable("course_id") int course_id, Model model) {
        // Course
        
    }

}
