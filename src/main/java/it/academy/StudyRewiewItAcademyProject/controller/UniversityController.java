package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityAddedColumn;
import it.academy.StudyRewiewItAcademyProject.models.AddedColumnModel;
import it.academy.StudyRewiewItAcademyProject.models.University;
import it.academy.StudyRewiewItAcademyProject.repos.CommentableEntityAddedColumnRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityAddedColumnService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    CommentableEntityService commentableEntityService;

    @GetMapping
    List<University> getAll() throws ParseException {
        return commentableEntityService.getAllUniversity();
    }

    @GetMapping("/{id}")
    University getById(@PathVariable("id") Long id) throws ParseException {
        return commentableEntityService.getUniversity(id);
    }

    @PostMapping
    University save(@RequestBody University university){
        return commentableEntityService.saveUniversity(university);
    }
}
