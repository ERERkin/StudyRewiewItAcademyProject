package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.models.Faculty;
import it.academy.StudyRewiewItAcademyProject.models.University;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    CommentableEntityService commentableEntityService;

    @GetMapping
    List<Faculty> getAll() throws ParseException {
        return commentableEntityService.getAllFaculty();
    }

    @GetMapping("/{id}")
    Faculty getById(@PathVariable("id") Long id) throws ParseException {
        return commentableEntityService.getFaculty(id);
    }

    @PostMapping
    Faculty save(@RequestBody Faculty faculty){
        return commentableEntityService.saveFaculty(faculty);
    }
}
