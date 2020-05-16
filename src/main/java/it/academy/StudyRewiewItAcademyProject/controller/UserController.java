package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.User;
import it.academy.StudyRewiewItAcademyProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/{login}")
    public List<User> getByLogin(@PathVariable("login") String login){
        return userService.findByLogin(login);
    }
    @DeleteMapping("/{login}")
    public void delete(@PathVariable("login") String login){
        userService.deleteByLogin(login);
    }


}
