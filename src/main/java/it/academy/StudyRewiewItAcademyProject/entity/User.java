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

    @Column (unique = true, nullable = false)
    String login;
    @Column (unique = false, nullable = false)
    String name;
    @Column (unique = false, nullable = false)
    String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Roles role;

}
