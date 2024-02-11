package com.vm189.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vm189.demo.dtos.UpdateCourse;

@RestController
// REpresentational State Transfer
public class RecordController {
    @PostMapping("/record/mark-as-complete/")
    public UpdateCourse mark_as_complete(@RequestBody UpdateCourse data, Model model) {
        // repository will update the course of the user as done
        System.out.println("course id " + data.getCourse_id() + " User-ID" + data.getUser_id());
        return data;
    }
    
    @PostMapping("/record/mark-as-incomplete/")
    public UpdateCourse mark_as_incomplete(@RequestBody UpdateCourse data, Model model) {
        // repository will update the course of the user as done
        System.out.println("course id " + data.getCourse_id() + " User-ID" + data.getUser_id());
        return data;
    }
}
