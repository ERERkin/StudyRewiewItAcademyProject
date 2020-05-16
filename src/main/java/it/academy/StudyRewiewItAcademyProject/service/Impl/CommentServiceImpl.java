package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.repos.CommentRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

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
}
