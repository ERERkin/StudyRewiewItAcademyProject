package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.models.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface CommentableEntityService extends BaseService<CommentableEntity>{
    Department saveDepartment(Department entity);

    Department getDepartment(Long id) throws ParseException;

    Employee saveEmployee(Employee entity);

    Employee getEmployee(Long id);

    University saveUniversity(University entity);

    University getUniversity(Long id) throws ParseException;

    Faculty saveFaculty(Faculty entity);

    Faculty getFaculty(Long id) throws ParseException;

    Specialty saveSpeciality(Specialty entity);

    Specialty getSpeciality(Long id) throws ParseException;
}
