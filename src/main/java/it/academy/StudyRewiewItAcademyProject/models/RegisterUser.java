package it.academy.StudyRewiewItAcademyProject.models;


import lombok.*;

import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "register_user")
public class RegisterUser {
    String login;
    String password;
    String name;
}
