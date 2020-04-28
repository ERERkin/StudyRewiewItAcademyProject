package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumn;
import it.academy.StudyRewiewItAcademyProject.repos.CommentableEntityColumnRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentableEntityColumnServiceImpl implements CommentableEntityColumnService {
    @Autowired
    private CommentableEntityColumnRepo commentableEntityColumnRepo;
    @Override
    public CommentableEntityColumn getById(Long id) {
        Optional<CommentableEntityColumn> commentableEntityColumn = commentableEntityColumnRepo.findById(id);
        return commentableEntityColumn.get();
    }

    @Override
    public void delete(Long id) {
        commentableEntityColumnRepo.deleteById(id);
    }

    @Override
    public List<CommentableEntityColumn> getAll() {
        return commentableEntityColumnRepo.findAll();
    }

    @Override
    public CommentableEntityColumn save(CommentableEntityColumn item) {
        return commentableEntityColumnRepo.save(item);
    }
}
