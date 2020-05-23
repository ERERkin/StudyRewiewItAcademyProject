package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.models.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface CommentableEntityService extends BaseService<CommentableEntity>{
    Department saveDepartment(Department entity) ;

    Department getDepartment(Long id) throws ParseException;

    List<Department> getAllDepartment() throws ParseException;

    List<Department> getAllDepartmentByFaculty(Long id) throws ParseException;

    Employee saveEmployee(Employee entity);

    Employee getEmployee(Long id) throws ParseException;

    List<Employee> getAllEmployee() throws ParseException;

    List<Employee> getAllEmployeeByDepartment(Long id) throws ParseException;

    University saveUniversity(University entity);

    University getUniversity(Long id) throws ParseException;

    List<University> getAllUniversity() throws ParseException;

    Faculty saveFaculty(Faculty entity);

    Faculty getFaculty(Long id) throws ParseException;

    List<Faculty> getAllFaculty() throws ParseException;

    List<Faculty> getAllFacultyByUniversity(Long id) throws ParseException;

    Specialty saveSpecialty(Specialty entity);

    Specialty getSpeciality(Long id) throws ParseException;

    List<Specialty> getAllSpeciality() throws ParseException;

    List<Specialty> getAllSpecialityByDepartment(Long id) throws ParseException;

    String getType(Long id);
}
