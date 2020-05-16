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
public class University {
    Long id;
    String name;
    String address;
    Employee rector;
    String createDate;
}
