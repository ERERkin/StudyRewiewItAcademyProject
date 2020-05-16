package it.academy.StudyRewiewItAcademyProject.entity;

import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column (unique = true, nullable = false)
    String login;

//    @Column (unique = false, nullable = false)
//    String name;

    @Column (unique = false, nullable = false)
    String password;

    @NotNull
    @Column(name = "is_active")
    int isActive;
}
