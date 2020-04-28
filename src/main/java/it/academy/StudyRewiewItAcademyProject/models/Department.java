package it.academy.StudyRewiewItAcademyProject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    Integer id;
    String name;
    Integer facultyId;
    Integer headOfDepartmentId;
    Date createDate;
}
