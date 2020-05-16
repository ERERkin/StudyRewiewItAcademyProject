package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query( value = "select * from st_user u where u.login = :login", nativeQuery=true)
    List<User> findByLogin(@Param("login") String login);
    @Query( value = "delete * from st_user u where u.login = :login", nativeQuery=true)
    void deleteByLogin(@Param("login") String login);
}
