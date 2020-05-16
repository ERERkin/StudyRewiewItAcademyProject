package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService extends BaseService<Comment> {

    @Override
    Comment getById(Long id);

    @Override
    List<Comment> getAll();

    @Override
    Comment save(Comment item);

    @Override
    void delete(Long id);
}
