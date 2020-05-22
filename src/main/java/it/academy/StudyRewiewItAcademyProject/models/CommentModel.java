package it.academy.StudyRewiewItAcademyProject.models;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentModel {
    Long id;
    String comment;
    String time;
}
