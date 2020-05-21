package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.models.CommentModel;
import it.academy.StudyRewiewItAcademyProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping()
    Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @GetMapping
    List<Comment> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    Comment getById(@PathVariable("id") Long id){
        return commentService.getById(id);
    }

    @GetMapping("/entity/{id}")
    List<CommentModel> getCommentsByCommentableId(@PathVariable("id") Long id) throws ParseException {
        return commentService.getAllByEntity(id);
    }
}
