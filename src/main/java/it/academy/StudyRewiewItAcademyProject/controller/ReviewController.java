package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.models.ReviewModel;
import it.academy.StudyRewiewItAcademyProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping()
    Review save(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping
    List<Review> getAll(){
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    Review getById(@PathVariable("id") Long id){
        return reviewService.getById(id);
    }

    @GetMapping("/entity/{id}")
    List<ReviewModel> getCommentsByCommentableId(@PathVariable("id") Long id) throws ParseException {
        return reviewService.getAllByEntity(id);
    }
}
