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
public class Department implements Model{
    Long id;
    String name;
    Faculty facultyId;
    Employee headOfDepartmentId;
    String createDate;
    List<AddedColumnModel> addedColumnModels;
}
