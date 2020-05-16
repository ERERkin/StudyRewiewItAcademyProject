package it.academy.StudyRewiewItAcademyProject.service;
import it.academy.StudyRewiewItAcademyProject.entity.Roles;
import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolesService extends BaseService<Roles> {
    @Override
    Roles getById(Long id);

    @Override
    List<Roles> getAll();

    @Override
    Roles save(Roles item);

    @Override
    void delete(Long id);


}
