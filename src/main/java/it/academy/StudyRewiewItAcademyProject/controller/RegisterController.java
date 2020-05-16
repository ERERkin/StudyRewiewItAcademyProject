package it.academy.StudyRewiewItAcademyProject.controller;

import it.academy.StudyRewiewItAcademyProject.entity.Roles;
import it.academy.StudyRewiewItAcademyProject.entity.User;
import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import it.academy.StudyRewiewItAcademyProject.models.RegisterUser;
import it.academy.StudyRewiewItAcademyProject.repos.RolesRepo;
import it.academy.StudyRewiewItAcademyProject.repos.UserRepo;
import it.academy.StudyRewiewItAcademyProject.service.Impl.RolesServiceImpl;
import it.academy.StudyRewiewItAcademyProject.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping
public class RegisterController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    ///Postman 404, no v BD sohranyayet
    public String doRegister(@RequestBody RegisterUser registerUser) {
        String encodedPassword  = passwordEncoder.encode(registerUser.getPassword());
        User user = new User();
        user.setPassword(encodedPassword);
        user.setLogin(registerUser.getLogin());
        // role_Name is saved as a number not ENUM
        //user.setName(registerUser.getName());
        //user.setRole(rolesRepo.findByName("STUDENT"));
        userRepo.save(user);
        return "User " + registerUser.getLogin() + " is successfully registered!";
    }

}
