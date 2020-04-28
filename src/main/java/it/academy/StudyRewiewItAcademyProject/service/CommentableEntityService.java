package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.models.Department;

import java.text.ParseException;

public interface CommentableEntityService extends BaseService<CommentableEntity>{
    Department saveEntity(Department entity);

    Department getEntity(Long id) throws ParseException;
}
