package com.bobbyplunkett.springWebAppExercise.controllers;

import com.bobbyplunkett.springWebAppExercise.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller class for {@link com.bobbyplunkett.springWebAppExercise.model.Student}
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 12:06 AM
 */
@Controller
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }
}
