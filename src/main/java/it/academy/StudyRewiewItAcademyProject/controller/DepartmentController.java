package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.models.Department;
import it.academy.StudyRewiewItAcademyProject.models.University;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    CommentableEntityService commentableEntityService;

    @GetMapping
    List<Department> getAll() throws ParseException {
        return commentableEntityService.getAllDepartment();
    }

    @GetMapping("/{id}")
    Department getById(@PathVariable("id") Long id) throws ParseException {
        return commentableEntityService.getDepartment(id);
    }

    @PostMapping
    Department save(@RequestBody Department department) throws ParseException {
        return commentableEntityService.saveDepartment(department);
    }
}
