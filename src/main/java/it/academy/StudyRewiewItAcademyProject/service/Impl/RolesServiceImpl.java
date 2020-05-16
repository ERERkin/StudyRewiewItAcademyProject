package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.Roles;
import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import it.academy.StudyRewiewItAcademyProject.repos.RolesRepo;
import it.academy.StudyRewiewItAcademyProject.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepo rolesRepo;

    @Override
    public Roles getById(Long id) {
        return rolesRepo.findById(id).get();
    }

    @Override
    public List<Roles> getAll() {
        return rolesRepo.findAll();
    }

    @Override
    public Roles save(Roles item) {
        return rolesRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        rolesRepo.deleteById(id);
    }

    public Roles findByName(String roleEnum){
        return rolesRepo.findByName(roleEnum);
    }

}
