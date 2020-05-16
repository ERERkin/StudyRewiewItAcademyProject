package it.academy.StudyRewiewItAcademyProject.Bootstrap;

import it.academy.StudyRewiewItAcademyProject.entity.Roles;
import it.academy.StudyRewiewItAcademyProject.entity.User;
import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import it.academy.StudyRewiewItAcademyProject.repos.RolesRepo;
import it.academy.StudyRewiewItAcademyProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private RolesRepo rolesRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
//        Roles roleStudent = new Roles(RoleEnum.STUDENT.name());
//        rolesRepo.save(roleStudent);
//        Roles roleAdmin = new Roles("ADMIN");
//        rolesRepo.save(roleAdmin);
//        Roles roleUser = new Roles(RoleEnum.USER.name());
//        rolesRepo.save(roleUser);
//
//        User admin = User.builder()
//                .login("admin")
//                .name("ADMIN")
//                .password(passwordEncoder.encode("123"))
//                .role(roleAdmin).build();
//        userRepo.save(admin);
        User admin = User.builder()
                .login("admin")
                .password(passwordEncoder.encode("123"))
                .isActive(1)
                .build();

        User user = User.builder()
                .login("user")
                .password(passwordEncoder.encode("456"))
                .isActive(1)
                .build();

        Roles adminRole = Roles.builder()
                .roleName("ROLE_ADMIN")
                .user(admin)
                .build();

        Roles userRole = Roles.builder()
                .roleName("ROLE_USER")
                .user(user)
                .build();

        userRepo.save(admin);
        userRepo.save(user);

        rolesRepo.save(adminRole);
        rolesRepo.save(userRole);
    }
}
