package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.Roles;
import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RolesRepo extends JpaRepository<Roles, Long> {
    @Query( value = "select * from roles r where r.role_Name = :roleEnum", nativeQuery=true)
    Roles findByName(@Param("roleEnum") String roleEnum);
}
