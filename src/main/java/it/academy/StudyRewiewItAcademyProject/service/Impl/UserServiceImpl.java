package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.User;
import it.academy.StudyRewiewItAcademyProject.repos.UserRepo;
import it.academy.StudyRewiewItAcademyProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User item) {
        return userRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override

    public List<User> findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    public void deleteByLogin(String login) {
        userRepo.deleteByLogin(login);
        System.err.println("Successfully deleted user: " + login);
    }
}
