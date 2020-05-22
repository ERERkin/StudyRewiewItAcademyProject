package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.models.*;
import it.academy.StudyRewiewItAcademyProject.service.CommentService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
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
    CommentableEntityService commentableEntityService;

    @GetMapping("/university")
    List<University> getAll() throws ParseException {
        return commentableEntityService.getAllUniversity();
    }

    @GetMapping("/university/{idUn}")
    SuperModel getById(@PathVariable Long idUn)  {
        SuperModel superModel = null;
        try {
            superModel = commentService.getSuperModel(idUn, "University");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superModel;
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

//    @PostMapping("/university")
//    University save(@RequestBody University university){
//        return commentableEntityService.saveUniversity(university);
//    }

    @GetMapping("/university/{idUn}/faculty")
    List<Faculty> getAll(@PathVariable String idUn) throws ParseException {
        return commentableEntityService.getAllFaculty();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}")
    SuperModel getById(@PathVariable Long idUn,
                    @PathVariable Long idFaculty) {
        SuperModel superModel = null;
        try {
            superModel = commentService.getSuperModel(idFaculty, "Faculty");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superModel;
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

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep")
    List<Department> getAll(@PathVariable Long idUn,
                            @PathVariable Long idFaculty) throws ParseException {
        return commentableEntityService.getAllDepartment();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}")
    SuperModel getById(@PathVariable Long idUn,
                       @PathVariable Long idFaculty,
                       @PathVariable Long idDep) throws ParseException {
        SuperModel superModel = null;
        try {
            superModel = commentService.getSuperModel(idDep, "Department");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superModel;
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

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec")
    List<Specialty> getAll(@PathVariable Long idUn,
                           @PathVariable Long idFaculty,
                           @PathVariable Long idDep) throws ParseException {
        return commentableEntityService.getAllSpeciality();
    }

    @GetMapping("/university/{idUn}/faculty/{idFaculty}/dep/{idDep}/spec/{idSpec}")
    SuperModel getById(@PathVariable Long idUn,
                      @PathVariable Long idFaculty,
                      @PathVariable Long idDep,
                      @PathVariable Long idSpec) throws ParseException {
        SuperModel superModel = null;
        try {
            superModel = commentService.getSuperModel(idSpec, "Department");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return superModel;
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
}
