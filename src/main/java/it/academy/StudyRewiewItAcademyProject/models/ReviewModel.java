package it.academy.StudyRewiewItAcademyProject.models;

import it.academy.StudyRewiewItAcademyProject.entity.Review;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewModel {
    Review review;
    Model model;
}
