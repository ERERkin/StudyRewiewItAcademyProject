package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.models.Employee;
import it.academy.StudyRewiewItAcademyProject.models.University;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityAddedColumnService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    CommentableEntityService commentableEntityService;

    @GetMapping
    List<Employee> getAll() throws ParseException {
        return commentableEntityService.getAllEmployee();
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable("id") Long id) throws ParseException {
        return commentableEntityService.getEmployee(id);
    }

    @PostMapping
    Employee save(@RequestBody Employee employee){
        return commentableEntityService.saveEmployee(employee);
    }
}
