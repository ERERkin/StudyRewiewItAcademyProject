package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.models.Department;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface CommentableEntityService extends BaseService<CommentableEntity>{
    Department saveEntity(Department entity);

    Department getEntity(Long id) throws ParseException;
}
