package it.academy.StudyRewiewItAcademyProject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee implements Model{
    Long id;
    String name;
    String phoneNumber;
    String mail;
    Department department;
    List<AddedColumnModel> addedColumnModels;
}
