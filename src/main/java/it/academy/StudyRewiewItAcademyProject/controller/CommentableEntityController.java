package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.models.*;
import it.academy.StudyRewiewItAcademyProject.service.CommentService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import it.academy.StudyRewiewItAcademyProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/entity")
public class CommentableEntityController {
    @Autowired
    CommentService commentService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    CommentableEntityService commentableEntityService;

    @GetMapping("/university")
    List<University> getAll() throws ParseException {
        return commentableEntityService.getAllUniversity();
    }

    @GetMapping("/university/added/{inf}")
    List<University> getAllByAddedColumnU(@PathVariable String inf) throws ParseException {
        System.err.println(inf);
        return commentableEntityService.getAllUniversityByAddedAndColumnsInf(inf);
    }

    @GetMapping("/university/{idUn}")
    SuperCommentModel getById(@PathVariable Long idUn)  {
        SuperCommentModel superCommentModel = null;
        try {
            superCommentModel = commentService.getSuperCommentModel(idUn, "University");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superCommentModel;
    }

    @PostMapping("/university/{idUn}")
    CommentModel save(@RequestBody CommentModel commentModel, @PathVariable Long idUn){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Comment comment = commentService.save(Comment.builder()
                .modelId(idUn)
                .comment(commentModel.getComment())
                .time(dateFormat.format(date))
                .build());
        return CommentModel.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .time(comment.getTime())
                .build();
    }

    @GetMapping("/university/{idUn}/review")
    SuperReviewModel getReviewById(@PathVariable Long idUn)  {
        SuperReviewModel superReviewModel = null;
        try {
            superReviewModel = reviewService.getSuperMReviewModel(idUn, "University");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superReviewModel;
    }

    @PostMapping("/university/{idUn}/review")
    ReviewModel saveReview(@RequestBody ReviewModel reviewModel,
                           @PathVariable Long idUn){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Review review = reviewService.save(Review.builder()
                .mark(reviewModel.getMark())
                .review(reviewModel.getReview())
                .modelId(idUn)
                .time(dateFormat.format(date))
                .build());
        return ReviewModel.builder()
                .id(review.getId())
                .review(review.getReview())
                .mark(review.getMark())
                .time(review.getTime())
                .build();
    }

//    @PostMapping("/university")
//    University save(@RequestBody University university){
//        return commentableEntityService.saveUniversity(university);
//    }

    @GetMapping("/university/{idUn}/faculty")
    List<Faculty> getAll(@PathVariable Long idUn) throws ParseException {
        return commentableEntityService.getAllFacultyByUniversity(idUn);
    }

    @GetMapping("/faculty/added/{inf}")
    List<Faculty> getAllByAddedColumnF(@PathVariable String inf) throws ParseException {
        return commentableEntityService.getAllFacultyByAddedAndColumnsInf(inf);
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}")
    SuperCommentModel getById(@PathVariable Long idUn,
                              @PathVariable Long idFaculty) {
        SuperCommentModel superCommentModel = null;
        try {
            superCommentModel = commentService.getSuperCommentModel(idFaculty, "Faculty");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superCommentModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}")
    CommentModel save(@RequestBody CommentModel commentModel,
                      @PathVariable Long idUn,
                      @PathVariable Long idFaculty) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Comment comment = commentService.save(Comment.builder()
                .modelId(idFaculty)
                .comment(commentModel.getComment())
                .time(dateFormat.format(date))
                .build());
        return CommentModel.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .time(comment.getTime())
                .build();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/review")
    SuperReviewModel getReviewById(@PathVariable Long idUn,
                                   @PathVariable Long idFaculty)  {
        SuperReviewModel superReviewModel = null;
        try {
            superReviewModel = reviewService.getSuperMReviewModel(idFaculty, "Faculty");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superReviewModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/review")
    ReviewModel saveReview(@RequestBody ReviewModel reviewModel,
                           @PathVariable Long idUn,
                           @PathVariable Long idFaculty){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Review review = reviewService.save(Review.builder()
                .mark(reviewModel.getMark())
                .review(reviewModel.getReview())
                .modelId(idFaculty)
                .time(dateFormat.format(date))
                .build());
        return ReviewModel.builder()
                .id(review.getId())
                .review(review.getReview())
                .mark(review.getMark())
                .time(review.getTime())
                .build();
    }


//    @PostMapping("/university/{idUn}/faculty")
//    Faculty save(@RequestBody Faculty faculty,
//                 @PathVariable Long idUn){
//        try {
//            faculty.setUniversity(commentableEntityService.getUniversity(idUn));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return commentableEntityService.saveFaculty(faculty);
//    }

    ///added/{inf}
    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep")
    List<Department> getAll(@PathVariable Long idUn,
                            @PathVariable Long idFaculty) throws ParseException {
        return commentableEntityService.getAllDepartmentByFaculty(idFaculty);
    }

    @GetMapping("/dep/added/{inf}")
    List<Department> getAllByAddedColumnD(@PathVariable String inf) throws ParseException {
        return commentableEntityService.getAllDepartmentByAddedAndColumnsInf(inf);
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}")
    SuperCommentModel getById(@PathVariable Long idUn,
                              @PathVariable Long idFaculty,
                              @PathVariable Long idDep) throws ParseException {
        SuperCommentModel superCommentModel = null;
        try {
            superCommentModel = commentService.getSuperCommentModel(idDep, "Department");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superCommentModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}")
    CommentModel save(@RequestBody CommentModel commentModel,
                      @PathVariable Long idUn,
                      @PathVariable Long idFaculty,
                      @PathVariable Long idDep)  {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Comment comment = commentService.save(Comment.builder()
                .modelId(idDep)
                .comment(commentModel.getComment())
                .time(dateFormat.format(date))
                .build());
        return CommentModel.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .time(comment.getTime())
                .build();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/review")
    SuperReviewModel getReviewById(@PathVariable Long idUn,
                                   @PathVariable Long idFaculty,
                                   @PathVariable Long idDep)  {
        SuperReviewModel superReviewModel = null;
        try {
            superReviewModel = reviewService.getSuperMReviewModel(idDep, "Department");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superReviewModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/review")
    ReviewModel saveReview(@RequestBody ReviewModel reviewModel,
                           @PathVariable Long idUn,
                           @PathVariable Long idFaculty,
                           @PathVariable Long idDep){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Review review = reviewService.save(Review.builder()
                .mark(reviewModel.getMark())
                .review(reviewModel.getReview())
                .modelId(idDep)
                .time(dateFormat.format(date))
                .build());
        return ReviewModel.builder()
                .id(review.getId())
                .review(review.getReview())
                .mark(review.getMark())
                .time(review.getTime())
                .build();
    }

//    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep")
//    Department save(@RequestBody Department department,
//                    @PathVariable Long idUn,
//                    @PathVariable Long idFaculty)  {
//        try {
//            department.setFacultyId(commentableEntityService.getFaculty(idFaculty));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return commentableEntityService.saveDepartment(department);
//    }
    ///added/{inf}
    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec")
    List<Specialty> getAll(@PathVariable Long idUn,
                           @PathVariable Long idFaculty,
                           @PathVariable Long idDep) throws ParseException {
        return commentableEntityService.getAllSpecialityByDepartment(idDep);
    }
    @GetMapping("/spec/added/{inf}")
    List<Specialty> getAllByAddedColumn(@PathVariable String inf) throws ParseException {
        return commentableEntityService.getAllSpecialtyByAddedAndColumnsInf(inf);
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec/{idSpec}")
    SuperCommentModel getById(@PathVariable Long idUn,
                              @PathVariable Long idFaculty,
                              @PathVariable Long idDep,
                              @PathVariable Long idSpec) throws ParseException {
        SuperCommentModel superCommentModel = null;
        try {
            superCommentModel = commentService.getSuperCommentModel(idSpec, "Specialty");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superCommentModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec/{idSpec}")
    CommentModel save(@RequestBody CommentModel commentModel,
                      @PathVariable Long idUn,
                      @PathVariable Long idFaculty,
                      @PathVariable Long idDep,
                      @PathVariable Long idSpec)  {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Comment comment = commentService.save(Comment.builder()
                .modelId(idSpec)
                .comment(commentModel.getComment())
                .time(dateFormat.format(date))
                .build());
        return CommentModel.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .time(comment.getTime())
                .build();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec/{idSpec}/review")
    SuperReviewModel getReviewById(@PathVariable Long idUn,
                                   @PathVariable Long idFaculty,
                                   @PathVariable Long idDep,
                                   @PathVariable Long idSpec)  {
        SuperReviewModel superReviewModel = null;
        try {
            superReviewModel = reviewService.getSuperMReviewModel(idSpec, "Specialty");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superReviewModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec/{idSpec}/review")
    ReviewModel saveReview(@RequestBody ReviewModel reviewModel,
                           @PathVariable Long idUn,
                           @PathVariable Long idFaculty,
                           @PathVariable Long idDep,
                           @PathVariable Long idSpec){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Review review = reviewService.save(Review.builder()
                .mark(reviewModel.getMark())
                .review(reviewModel.getReview())
                .modelId(idSpec)
                .time(dateFormat.format(date))
                .build());
        return ReviewModel.builder()
                .id(review.getId())
                .review(review.getReview())
                .mark(review.getMark())
                .time(review.getTime())
                .build();
    }

//    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec")
//    Specialty save(@RequestBody Specialty specialty,
//                   @PathVariable Long idUn,
//                   @PathVariable Long idFaculty,
//                   @PathVariable Long idDep){
//        try {
//            specialty.setDepartment(commentableEntityService.getDepartment(idDep));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return commentableEntityService.saveSpeciality(specialty);
//    }
    //ByAddedColumn
    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/emp")
    List<Employee> getAllEmp(@PathVariable Long idUn,
                           @PathVariable Long idFaculty,
                           @PathVariable Long idDep) throws ParseException {
        return commentableEntityService.getAllEmployeeByDepartment(idDep);
    }

    @GetMapping("/emp/added/{inf}")
    List<Employee> getAllEmpByAddedColumn(@PathVariable String inf) throws ParseException {
        return commentableEntityService.getAllEmployeeByAddedAndColumnsInf(inf);
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/emp/{idEmp}")
    SuperCommentModel getEmpById(@PathVariable Long idUn,
                              @PathVariable Long idFaculty,
                              @PathVariable Long idDep,
                              @PathVariable Long idEmp) throws ParseException {
        SuperCommentModel superCommentModel = null;
        try {
            superCommentModel = commentService.getSuperCommentModel(idEmp, "Employee");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superCommentModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/emp/{idEmp}")
    CommentModel saveEmp(@RequestBody CommentModel commentModel,
                      @PathVariable Long idUn,
                      @PathVariable Long idFaculty,
                      @PathVariable Long idDep,
                      @PathVariable Long idEmp)  {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Comment comment = commentService.save(Comment.builder()
                .modelId(idEmp)
                .comment(commentModel.getComment())
                .time(dateFormat.format(date))
                .build());
        return CommentModel.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .time(comment.getTime())
                .build();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/emp/{idEmp}/review")
    SuperReviewModel getEmpReviewById(@PathVariable Long idUn,
                                   @PathVariable Long idFaculty,
                                   @PathVariable Long idDep,
                                   @PathVariable Long idEmp)  {
        SuperReviewModel superReviewModel = null;
        try {
            superReviewModel = reviewService.getSuperMReviewModel(idEmp, "Employee");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superReviewModel;
    }

    @PostMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/emp/{idEmp}/review")
    ReviewModel saveEmpReview(@RequestBody ReviewModel reviewModel,
                           @PathVariable Long idUn,
                           @PathVariable Long idFaculty,
                           @PathVariable Long idDep,
                           @PathVariable Long idEmp){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Review review = reviewService.save(Review.builder()
                .mark(reviewModel.getMark())
                .review(reviewModel.getReview())
                .modelId(idEmp)
                .time(dateFormat.format(date))
                .build());
        return ReviewModel.builder()
                .id(review.getId())
                .review(review.getReview())
                .mark(review.getMark())
                .time(review.getTime())
                .build();
    }
}
