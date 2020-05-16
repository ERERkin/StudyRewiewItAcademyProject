package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface UserService extends BaseService<User> {
    @Override
    User getById(Long id);

    @Override
    List<User> getAll();

    @Override
    User save(User item);

    @Override
    void delete(Long id);

    List<User> findByLogin(String login);
    void deleteByLogin(String login);
}
