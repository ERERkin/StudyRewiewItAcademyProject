package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.models.CommentModel;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


public interface CommentService extends BaseService<Comment> {

    @Override
    Comment getById(Long id);

    @Override
    List<Comment> getAll();

    @Override
    Comment save(Comment item);

    @Override
    void delete(Long id);

    List<CommentModel> getAllByEntity(Long id) throws ParseException;
}
