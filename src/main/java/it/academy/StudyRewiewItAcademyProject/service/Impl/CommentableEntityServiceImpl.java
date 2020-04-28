package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumn;
import it.academy.StudyRewiewItAcademyProject.models.Department;
import it.academy.StudyRewiewItAcademyProject.repos.CommentableEntityRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityColumnService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentableEntityServiceImpl implements CommentableEntityService {
    @Autowired
    private CommentableEntityRepo commentableEntityRepo;
    @Autowired
    private CommentableEntityColumnService commentableEntityColumnService;
    @Override
    public CommentableEntity getById(Long id) {
        Optional<CommentableEntity> commentableEntity = commentableEntityRepo.findById(id);
        return commentableEntity.get();
    }

    @Override
    public void delete(Long id) {
        commentableEntityRepo.deleteById(id);
    }

    @Override
    public List<CommentableEntity> getAll() {
        return commentableEntityRepo.findAll();
    }

    @Override
    public CommentableEntity save(CommentableEntity item) {
        return commentableEntityRepo.save(item);
    }

    @Override
    public Department saveEntity(Department entity) {
//        commentableEntityColumnService.save(CommentableEntityColumn.builder()
//                .info("" + entity.)
//        )
//        commentableEntityRepo.save(CommentableEntity.builder()
//                .
//        )
        return entity;
    }
}
