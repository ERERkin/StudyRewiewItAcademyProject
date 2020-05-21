package it.academy.StudyRewiewItAcademyProject.models;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentModel {
    Comment comment;
    Model model;
}
