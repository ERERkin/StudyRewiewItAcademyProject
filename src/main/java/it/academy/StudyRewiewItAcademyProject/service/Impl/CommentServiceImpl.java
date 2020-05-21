package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.models.CommentModel;
import it.academy.StudyRewiewItAcademyProject.models.ReviewModel;
import it.academy.StudyRewiewItAcademyProject.repos.CommentRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    CommentableEntityService commentableEntityService;

    @Override
    public Comment getById(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment save(Comment item) {
        return commentRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public List<CommentModel> getAllByEntity(Long id) throws ParseException {
        List<CommentModel> commentModels = new ArrayList<>();
        List<Comment> comments = commentRepo.getAllByCommentableEntity(id);
        for(Comment c : comments){
            String s = commentableEntityService.getType(id);
            if(s.equals("Department"))
                commentModels.add(CommentModel.builder()
                        .comment(c)
                        .model(commentableEntityService.getDepartment(id))
                        .build());
            else if(s.equals("Employee"))
                commentModels.add(CommentModel.builder()
                        .comment(c)
                        .model(commentableEntityService.getEmployee(id))
                        .build());
            else if(s.equals("University"))
                commentModels.add(CommentModel.builder()
                        .comment(c)
                        .model(commentableEntityService.getUniversity(id))
                        .build());
            else if(s.equals("Faculty"))
                commentModels.add(CommentModel.builder()
                        .comment(c)
                        .model(commentableEntityService.getFaculty(id))
                        .build());
            else if(s.equals("Speciality"))
                commentModels.add(CommentModel.builder()
                        .comment(c)
                        .model(commentableEntityService.getSpeciality(id))
                        .build());
        }
        return commentModels;
    }
}
