package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.User;
import it.academy.StudyRewiewItAcademyProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@PreAuthorize("hasRole('ADMIN')")
//@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/{login}")
//    public List<User> getByLogin(@PathVariable("login") String login){
//        return userService.findByLogin(login);
//    }
    @GetMapping("/{id}")
    public String getByLogin(@PathVariable("id") Integer id){
        return "Hello" + id;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{login}")
    public void delete(@PathVariable("login") String login){
        userService.deleteByLogin(login);
    }
}
