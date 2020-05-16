package it.academy.StudyRewiewItAcademyProject.entity;
import it.academy.StudyRewiewItAcademyProject.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "role_name", unique = true)
    String roleName;

    public Roles(String name) {
        roleName = name;
    }
}
