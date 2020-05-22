package it.academy.StudyRewiewItAcademyProject.models;

import it.academy.StudyRewiewItAcademyProject.entity.Review;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewModel {
    Long id;
    String review;
    Integer mark;
    String time;
}
