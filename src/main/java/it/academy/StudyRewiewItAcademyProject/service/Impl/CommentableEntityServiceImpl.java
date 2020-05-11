package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumn;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumnLink;
import it.academy.StudyRewiewItAcademyProject.models.Department;
import it.academy.StudyRewiewItAcademyProject.models.Employee;
import it.academy.StudyRewiewItAcademyProject.models.Faculty;
import it.academy.StudyRewiewItAcademyProject.models.University;
import it.academy.StudyRewiewItAcademyProject.repos.CommentableEntityRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityColumnLinkService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityColumnService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentableEntityServiceImpl implements CommentableEntityService {
    @Autowired
    private CommentableEntityRepo commentableEntityRepo;
    @Autowired
    private CommentableEntityColumnService commentableEntityColumnService;
    @Autowired
    private CommentableEntityColumnLinkService commentableEntityColumnLinkService;
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
    public Employee saveEmployee(Employee entity) {
        CommentableEntity commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .name(entity.getName())
                .type("Employee")
                .build()
        );
        commentableEntityColumnService.save(
                CommentableEntityColumn.builder()
                        .infoType("Mail")
                        .info(entity.getMail())
                        .entity(commentableEntity)
                        .build()
        );
        commentableEntityColumnService.save(
                CommentableEntityColumn.builder()
                        .infoType("Phone")
                        .info(entity.getPhoneNumber())
                        .entity(commentableEntity)
                        .build()
        );
        return entity;
    }

    @Override
    public CommentableEntity save(CommentableEntity item) {
        return commentableEntityRepo.save(item);
    }

    @Override
    public Department saveDepartment(Department entity) {
//        commentableEntityColumnService.save(CommentableEntityColumn.builder()
//                .info("" + entity.)
//        )
        CommentableEntity commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .name(entity.getName())
                .type("Department")
                .build()
        );
        CommentableEntity faculty = commentableEntityRepo.findById(entity.getFacultyId().getId()).get();
        CommentableEntity head = commentableEntityRepo.findById(entity.getHeadOfDepartmentId().getId()).get();
        commentableEntityColumnService.save(
                CommentableEntityColumn.builder()
                        .infoType("Date")
                        .info(entity.getCreateDate().toString())
                        .entity(commentableEntity)
                        .build()
        );
        commentableEntityColumnLinkService.save(
                CommentableEntityColumnLink.builder()
                        .columnEntity(faculty)
                        .entity(commentableEntity)
                        .columnName("Faculty")
                        .build()
        );
        commentableEntityColumnLinkService.save(
                CommentableEntityColumnLink.builder()
                        .columnEntity(head)
                        .entity(commentableEntity)
                        .columnName("HeadOfDep")
                        .build()
        );
        return entity;
    }

    @Override
    public University saveUniversity(University entity) {
        CommentableEntity commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .name(entity.getName())
                .type("University")
                .build()
        );
        //Long id;
        //    String name;
        //    String address;
        //    Employee rector;
        //    Date createDate;
        commentableEntityColumnService.save(
                CommentableEntityColumn.builder()
                        .infoType("Address")
                        .info(entity.getAddress())
                        .entity(commentableEntity)
                        .build()
        );
        commentableEntityColumnService.save(
                CommentableEntityColumn.builder()
                        .infoType("Date")
                        .info(entity.getCreateDate().toString())
                        .entity(commentableEntity)
                        .build()
        );
        commentableEntityColumnLinkService.save(
                CommentableEntityColumnLink.builder()
                        .columnName("Employee")
                        .columnEntity(getById(entity.getRector().getId()))
                        .entity(getById(entity.getId()))
                        .build()
        );
        return null;
    }

    @Override
    public University getUniversity(Long id) {
        return null;
    }

    @Override
    public Department getDepartment(Long id) throws ParseException {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        List<CommentableEntityColumn> commentableEntityColumns = commentableEntity.getColumns();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        Date date = null;
        Faculty faculty = null;
        for(CommentableEntityColumn c : commentableEntityColumns){
            if(c.getInfoType().equals("Date"))
                date = new SimpleDateFormat("dd/MM/yyyy").parse(c.getInfo());
        }
        for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
            /*if(c.getColumnName().equals("Faculty"))
                faculty = c.getEntity();*/
        }
        Department department = Department.builder()
                .id(commentableEntity.getId())
                .name(commentableEntity.getName())
                .headOfDepartmentId(new Employee())
                .facultyId(new Faculty())
                .createDate(date)
                .build();
        return null;
    }

    @Override
    public Employee getEmployee(Long id) {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        List<CommentableEntityColumn> commentableEntityColumns = commentableEntity.getColumns();
        //List<CommentableEntityColumnLink> commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        String mail = null;
        String phone = null;
        for(CommentableEntityColumn c : commentableEntityColumns){
            if(c.getInfoType().equals("Mail"))
                mail = c.getInfo();
            else if(c.getInfoType().equals("Phone"))
                phone = c.getInfo();
        }
        Employee employee = Employee.builder()
                .id(id)
                .mail(mail)
                .name(commentableEntity.getName())
                .phoneNumber(phone)
                .build();
        return employee;
    }
}
