package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.models.Specialty;
import it.academy.StudyRewiewItAcademyProject.models.University;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    CommentableEntityService commentableEntityService;

    @GetMapping
    List<Specialty> getAll() throws ParseException {
        return commentableEntityService.getAllSpeciality();
    }

    @GetMapping("/{id}")
    Specialty getById(@PathVariable("id") Long id) throws ParseException {
        return commentableEntityService.getSpeciality(id);
    }

    @PostMapping
    Specialty save(@RequestBody Specialty specialty){
        return commentableEntityService.saveSpeciality(specialty);
    }
}
