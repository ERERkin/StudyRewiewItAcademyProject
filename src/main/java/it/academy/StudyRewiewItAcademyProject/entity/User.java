package it.academy.StudyRewiewItAcademyProject.entity;

import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "st_user")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column (name = "login", unique = true, nullable = false)
    String login;
    @Column (name = "name",unique = false, nullable = false)
    String name;
    @Column (name = "password",unique = false, nullable = false)
    String password;


}
