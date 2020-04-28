package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.models.Department;

public interface CommentableEntityService extends BaseService<CommentableEntity>{
    Department saveEntity(Department entity);
}
