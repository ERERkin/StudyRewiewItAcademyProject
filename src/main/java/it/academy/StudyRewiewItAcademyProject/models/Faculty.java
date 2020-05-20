package it.academy.StudyRewiewItAcademyProject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Faculty {
    Long id;
    String name;
    University university;
    String createDate;
    Employee facultyDean;
}
