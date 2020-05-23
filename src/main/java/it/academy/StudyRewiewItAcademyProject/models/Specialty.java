package it.academy.StudyRewiewItAcademyProject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Specialty implements Model{
    Long id;
    String name;
    Department department;
    Integer contractSum;
    List<AddedColumnModel> addedColumnModels;
}
