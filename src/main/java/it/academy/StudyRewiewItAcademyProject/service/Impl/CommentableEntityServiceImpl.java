package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumn;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumnLink;
import it.academy.StudyRewiewItAcademyProject.models.*;
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
    public CommentableEntity save(CommentableEntity item) {
        return commentableEntityRepo.save(item);
    }

    @Override
    public List<CommentableEntity> getAll() {
        return commentableEntityRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee entity) {
        CommentableEntity commentableEntity;
        List<CommentableEntityColumn> commentableEntityColumns = new ArrayList<>();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = new ArrayList<>();
        if(commentableEntityRepo.findCount(entity.getId()) > 0) {
            commentableEntity = commentableEntityRepo.findById(entity.getId()).get();
            commentableEntityColumns = commentableEntity.getColumns();
            commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        }
        commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type("Employee")
                .build()
        );
        CommentableEntityColumn commentableEntityColumn;
        CommentableEntityColumnLink commentableEntityColumnLink;
        if(commentableEntityRepo.findCount(entity.getId()) > 0){
            for(CommentableEntityColumn cec : commentableEntityColumns){
                if(cec.getInfoType().equals("Mail")){
                    commentableEntityColumn = commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(cec.getId())
                                    .infoType("Mail")
                                    .info(entity.getMail())
                                    .entity(commentableEntity)
                                    .build()
                    );
                    entity.setMail(commentableEntityColumn.getInfoType());
                }else if(cec.getInfoType().equals("Phone")){
                    commentableEntityColumn = commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(cec.getId())
                                    .infoType("Phone")
                                    .info(entity.getPhoneNumber())
                                    .entity(commentableEntity)
                                    .build()
                    );
                    entity.setPhoneNumber(commentableEntityColumn.getInfoType());
                }
            }
            for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
                if(c.getColumnName().equals("Department")) {
                    //department = getDepartment(c.getColumnEntity().getId());
                    commentableEntityColumnLink = commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("Department")
                                    .columnEntity(getById(entity.getDepartment().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                    try {
                        Department department = getDepartment(commentableEntityColumnLink.getId());
                        entity.setDepartment(department);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            commentableEntityColumn = commentableEntityColumnService.save(
                    CommentableEntityColumn.builder()
                            .infoType("Mail")
                            .info(entity.getMail())
                            .entity(commentableEntity)
                            .build()
            );
            entity.setMail(commentableEntityColumn.getInfoType());
            commentableEntityColumnService.save(
                    CommentableEntityColumn.builder()
                            .infoType("Phone")
                            .info(entity.getPhoneNumber())
                            .entity(commentableEntity)
                            .build()
            );
            entity.setPhoneNumber(commentableEntityColumn.getInfoType());
            if (entity.getDepartment() != null) {
                commentableEntityColumnLink = commentableEntityColumnLinkService.save(
                        CommentableEntityColumnLink.builder()
                                .columnName("Department")
                                .columnEntity(getById(entity.getDepartment().getId()))
                                .linkEntity(commentableEntity)
                                .build()
                );
//                try {
//                    Department department = getDepartment(commentableEntityColumnLink.getId());
//                    entity.setDepartment(department);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
            }
        }
        entity.setId(commentableEntity.getId());
        return entity;
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

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByType("Employee");
        for(CommentableEntity c : commentableEntities){
            employees.add(getEmployee(c.getId()));
        }
        return employees;
    }

    @Override
    public List<Employee> getAllEmployeeByDepartment(Long id) {
        List<Employee> employees = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByColumnEntity(id);
        for(CommentableEntity c : commentableEntities){
            employees.add(getEmployee(c.getId()));
        }
        return employees;
    }

    @Override
    public Department saveDepartment(Department entity) {
//        commentableEntityColumnService.save(CommentableEntityColumn.builder()
//                .info("" + entity.)
//        )
        CommentableEntity commentableEntity;
        List<CommentableEntityColumn> commentableEntityColumns = new ArrayList<>();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = new ArrayList<>();
        if(commentableEntityRepo.findCount(entity.getId()) > 0) {
            commentableEntity = commentableEntityRepo.findById(entity.getId()).get();
            commentableEntityColumns = commentableEntity.getColumns();
            commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        }
        commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type("Department")
                .build()
        );
        //Long id;
        //    String name;
        //    Faculty facultyId;
        //    Employee headOfDepartmentId;
        //    Date createDate;
        if(commentableEntityRepo.findCount(entity.getId()) > 0){
            for(CommentableEntityColumn c : commentableEntityColumns){
                if(c.getInfoType().equals("Date")) {
                    //date = new SimpleDateFormat("dd/MM/yyyy").parse(c.getInfo());
                    commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(c.getId())
                                    .infoType("Date")
                                    .info(entity.getCreateDate())
                                    .entity(commentableEntity)
                                    .build()
                    );
                }
            }
            for(CommentableEntityColumnLink c : commentableEntityColumnLinks) {
                if (c.getColumnName().equals("Faculty")) {
                    //faculty = getFaculty(c.getColumnEntity().getId());
                    commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("Faculty")
                                    .columnEntity(getById(entity.getFacultyId().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                } else if (c.getColumnName().equals("Employee")) {
                    commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("Employee")
                                    .columnEntity(getById(entity.getHeadOfDepartmentId().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                }
            }
        }else {
            CommentableEntity faculty = commentableEntityRepo.findById(entity.getFacultyId().getId()).get();
            CommentableEntity head = commentableEntityRepo.findById(entity.getHeadOfDepartmentId().getId()).get();
            commentableEntityColumnService.save(
                    CommentableEntityColumn.builder()
                            .infoType("Date")
                            .info(entity.getCreateDate())
                            .entity(commentableEntity)
                            .build()
            );
            commentableEntityColumnLinkService.save(
                    CommentableEntityColumnLink.builder()
                            .columnEntity(faculty)
                            .linkEntity(commentableEntity)
                            .columnName("Faculty")
                            .build()
            );
            commentableEntityColumnLinkService.save(
                    CommentableEntityColumnLink.builder()
                            .columnEntity(head)
                            .linkEntity(commentableEntity)
                            .columnName("HeadOfDep")
                            .build()
            );
        }
        return entity;
    }

    @Override
    public Department getDepartment(Long id) throws ParseException {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        List<CommentableEntityColumn> commentableEntityColumns = commentableEntity.getColumns();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        String date = null;
        Faculty faculty = null;
        Employee headOfDep = null;
        for(CommentableEntityColumn c : commentableEntityColumns){
            if(c.getInfoType().equals("Date"))
                date = c.getInfo();
        }
        for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
            if(c.getColumnName().equals("Faculty"))
                faculty = getFaculty(c.getColumnEntity().getId());
            else if(c.getColumnName().equals("Employee"))
                headOfDep = getEmployee(c.getColumnEntity().getId());
        }
        Department department = Department.builder()
                .id(commentableEntity.getId())
                .name(commentableEntity.getName())
                .headOfDepartmentId(headOfDep)
                .facultyId(faculty)
                .createDate(date)
                .build();
        return department;
    }

    @Override
    public List<Department> getAllDepartment() throws ParseException {
        List<Department> departments = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByType("Department");
        for(CommentableEntity c : commentableEntities){
            departments.add(getDepartment(c.getId()));
        }
        return departments;
    }

    @Override
    public List<Department> getAllDepartmentByFaculty(Long id) throws ParseException {
        List<Department> departments = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByColumnEntity(id);
        for(CommentableEntity c : commentableEntities){
            departments.add(getDepartment(c.getId()));
        }
        return departments;
    }


    @Override
    public University saveUniversity(University entity) {
        CommentableEntity commentableEntity;
        List<CommentableEntityColumn> commentableEntityColumns = new ArrayList<>();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = new ArrayList<>();
        if(commentableEntityRepo.findCount(entity.getId()) > 0) {
            commentableEntity = commentableEntityRepo.findById(entity.getId()).get();
            commentableEntityColumns = commentableEntity.getColumns();
            commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        }
        commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type("University")
                .build()
        );
        if(commentableEntityRepo.findCount(entity.getId()) > 0) {
            for(CommentableEntityColumn c : commentableEntityColumns){
                if(c.getInfoType().equals("Address")){
                    commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(c.getId())
                                    .infoType("Address")
                                    .info(entity.getAddress())
                                    .entity(commentableEntity)
                                    .build()
                    );
                }else if(c.getInfoType().equals("")){
                    commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(c.getId())
                                    .infoType("Date")
                                    .info(entity.getCreateDate())
                                    .entity(commentableEntity)
                                    .build()
                    );
                }
            }
            for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
                if(c.getColumnName().equals("Employee")){
                    commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("Employee")
                                    .columnEntity(getById(entity.getRector().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                }
            }
        }else{
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
                            .info(entity.getCreateDate())
                            .entity(commentableEntity)
                            .build()
            );
            commentableEntityColumnLinkService.save(
                    CommentableEntityColumnLink.builder()
                            .columnName("Employee")
                            .columnEntity(getById(entity.getRector().getId()))
                            .linkEntity(commentableEntity)
                            .build()
            );
        }
        return entity;
    }

    @Override
    public University getUniversity(Long id) throws ParseException {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        List<CommentableEntityColumn> commentableEntityColumns = commentableEntity.getColumns();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        //Long id;
        //    String name;
        //    String address;
        //    Employee rector;
        //    Date createDate;
        String address = null;
        Employee rector = null;
        String date = null;
        for(CommentableEntityColumn c : commentableEntityColumns){
            if(c.getInfoType().equals("Date"))
                date = (c.getInfo());
            else if(c.getInfoType().equals("Address"))
                address = c.getInfo();
        }
        for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
            /*if(c.getColumnName().equals("Faculty"))
                faculty = c.getEntity();*/
            System.err.println(c.getColumnName());
            if(c.getColumnName().equals("Employee"))
                rector = getEmployee(c.getColumnEntity().getId());
        }
        University university = University.builder()
                .id(id)
                .address(address)
                .createDate(date)
                .name(commentableEntity.getName())
                .rector(rector)
                .build();
        return university;
    }

    @Override
    public List<University> getAllUniversity() throws ParseException {
        List<University> universities = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByType("University");
        for(CommentableEntity c : commentableEntities){
            universities.add(getUniversity(c.getId()));
        }
        return universities;
    }

    @Override
    public Faculty saveFaculty(Faculty entity) {
        CommentableEntity commentableEntity;
        List<CommentableEntityColumn> commentableEntityColumns = new ArrayList<>();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = new ArrayList<>();
        if(commentableEntityRepo.findCount(entity.getId()) > 0) {
            commentableEntity = commentableEntityRepo.findById(entity.getId()).get();
            commentableEntityColumns = commentableEntity.getColumns();
            commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        }
        commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .name(entity.getName())
                .type("Faculty")
                .build()
        );
        //Long id;
        //    String name;
        //    University university;
        //    Date createDate;
        //    Employee facultyDean;
        if(commentableEntityRepo.findCount(entity.getId()) > 0){
            for(CommentableEntityColumn c : commentableEntityColumns){
                if(c.getInfoType().equals("Date")){
                    commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(c.getId())
                                    .infoType("Date")
                                    .info(entity.getCreateDate())
                                    .entity(commentableEntity)
                                    .build()
                    );
                }
            }
            for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
                if(c.getColumnName().equals("Employee")){
                    commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("Employee")
                                    .columnEntity(getById(entity.getFacultyDean().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                }
                else if(c.getColumnName().equals("University")){
                    commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("University")
                                    .columnEntity(getById(entity.getUniversity().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                }
            }
        }else {
            commentableEntityColumnService.save(
                    CommentableEntityColumn.builder()
                            .infoType("Date")
                            .info(entity.getCreateDate())
                            .entity(commentableEntity)
                            .build()
            );
            commentableEntityColumnLinkService.save(
                    CommentableEntityColumnLink.builder()
                            .columnName("Employee")
                            .columnEntity(getById(entity.getFacultyDean().getId()))
                            .linkEntity(commentableEntity)
                            .build()
            );
            commentableEntityColumnLinkService.save(
                    CommentableEntityColumnLink.builder()
                            .columnName("University")
                            .columnEntity(getById(entity.getUniversity().getId()))
                            .linkEntity(commentableEntity)
                            .build()
            );
        }
        return entity;
    }

    @Override
    public Faculty getFaculty(Long id) throws ParseException {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        List<CommentableEntityColumn> commentableEntityColumns = commentableEntity.getColumns();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        Employee facultyDean = null;
        String date = null;
        University university = null;
        for(CommentableEntityColumn c : commentableEntityColumns){
            if(c.getInfoType().equals("Date"))
                //date = new SimpleDateFormat("dd/MM/yyyy").parse(c.getInfo());
                date = c.getInfo();
        }
        for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
            if(c.getColumnName().equals("Employee"))
                facultyDean = getEmployee(c.getColumnEntity().getId());
            else if(c.getColumnName().equals("University")){
                university = getUniversity(c.getColumnEntity().getId());
            }
        }
        Faculty faculty = Faculty.builder()
                .createDate(date)
                .id(id)
                .facultyDean(facultyDean)
                .name(commentableEntity.getName())
                .university(university)
                .build();
        return faculty;
    }

    @Override
    public List<Faculty> getAllFaculty() throws ParseException {
        List<Faculty> faculties = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByType("Faculty");
        for(CommentableEntity c : commentableEntities){
            faculties.add(getFaculty(c.getId()));
        }
        return faculties;
    }

    @Override
    public List<Faculty> getAllFacultyByUniversity(Long id) throws ParseException {
        List<Faculty> faculties = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByColumnEntity(id);
        for(CommentableEntity c : commentableEntities){
            faculties.add(getFaculty(c.getId()));
        }
        return faculties;
    }

    @Override
    public Specialty saveSpecialty(Specialty entity) {
        CommentableEntity commentableEntity;
        List<CommentableEntityColumn> commentableEntityColumns = new ArrayList<>();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = new ArrayList<>();
        if(commentableEntityRepo.findCount(entity.getId()) > 0) {
            commentableEntity = commentableEntityRepo.findById(entity.getId()).get();
            commentableEntityColumns = commentableEntity.getColumns();
            commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        }
        commentableEntity = commentableEntityRepo.save(CommentableEntity.builder()
                .name(entity.getName())
                .type("Specialty")
                .build()
        );
        //Long id;
        //    String name;
        //    Department department;
        //    Integer contractSum;
        if(commentableEntityRepo.findCount(entity.getId()) > 0){
            for(CommentableEntityColumn c : commentableEntityColumns){
                if(c.getInfoType().equals("Sum")) {
                    //sum = Integer.parseInt(c.getInfo());
                    commentableEntityColumnService.save(
                            CommentableEntityColumn.builder()
                                    .id(c.getId())
                                    .infoType("Sum")
                                    .info(entity.getContractSum().toString())
                                    .entity(commentableEntity)
                                    .build()
                    );
                }
            }
            for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
                if(c.getColumnName().equals("Department")) {
                    //department = getDepartment(c.getColumnEntity().getId());
                    commentableEntityColumnLinkService.save(
                            CommentableEntityColumnLink.builder()
                                    .id(c.getId())
                                    .columnName("Department")
                                    .columnEntity(getById(entity.getDepartment().getId()))
                                    .linkEntity(commentableEntity)
                                    .build()
                    );
                }
            }
        }else {
            commentableEntityColumnService.save(
                    CommentableEntityColumn.builder()
                            .infoType("Sum")
                            .info(entity.getContractSum().toString())
                            .entity(commentableEntity)
                            .build()
            );
            commentableEntityColumnLinkService.save(
                    CommentableEntityColumnLink.builder()
                            .columnName("Department")
                            .columnEntity(getById(entity.getDepartment().getId()))
                            .linkEntity(commentableEntity)
                            .build()
            );
        }
        return entity;
    }

    @Override
    public Specialty getSpeciality(Long id) throws ParseException {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        List<CommentableEntityColumn> commentableEntityColumns = commentableEntity.getColumns();
        List<CommentableEntityColumnLink> commentableEntityColumnLinks = commentableEntity.getLinkColumns();
        Department department = null;
        Integer sum = null;
        for(CommentableEntityColumn c : commentableEntityColumns){
            if(c.getInfoType().equals("Sum"))
                sum = Integer.parseInt(c.getInfo());
        }
        for(CommentableEntityColumnLink c : commentableEntityColumnLinks){
            if(c.getColumnName().equals("Department"))
                department = getDepartment(c.getColumnEntity().getId());
        }
        Specialty specialty = Specialty.builder()
                .id(id)
                .name(commentableEntity.getName())
                .contractSum(sum)
                .department(department)
                .build();
        return specialty;
    }

    @Override
    public List<Specialty> getAllSpeciality() throws ParseException {
        List<Specialty> specialties = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByType("Specialty");
        for(CommentableEntity c : commentableEntities){
            specialties.add(getSpeciality(c.getId()));
        }
        return specialties;
    }

    @Override
    public List<Specialty> getAllSpecialityByDepartment(Long id) throws ParseException {
        List<Specialty> specialties = new ArrayList<>();
        List<CommentableEntity> commentableEntities = commentableEntityRepo.findAllByColumnEntity(id);
        for(CommentableEntity c : commentableEntities){
            specialties.add(getSpeciality(c.getId()));
        }
        return specialties;
    }

    @Override
    public String getType(Long id) {
        CommentableEntity commentableEntity = commentableEntityRepo.findById(id).get();
        return commentableEntity.getType();
    }
}
