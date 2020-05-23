package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityAddedColumn;
import it.academy.StudyRewiewItAcademyProject.models.AddedColumnModel;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityAddedColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/add")
public class AddedColumnController {
    @Autowired
    CommentableEntityAddedColumnService commentableEntityAddedColumnService;

    @GetMapping
    List<AddedColumnModel> getAll(){
        List<AddedColumnModel> addedColumnModels = new ArrayList<>();
        try {
            addedColumnModels = commentableEntityAddedColumnService.getAllModel();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ;
        return addedColumnModels;
    }

    @PostMapping
    AddedColumnModel save(@RequestBody CommentableEntityAddedColumn commentableEntityAddedColumn){
        AddedColumnModel addedColumnModel = null;
        try {
            addedColumnModel = commentableEntityAddedColumnService.saveModel(commentableEntityAddedColumn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return addedColumnModel;
    }
}
