package it.academy.StudyRewiewItAcademyProject.entity;

import it.academy.StudyRewiewItAcademyProject.models.Model;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "st_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "review")
    String review;

    @Column(name = "mark")
    Integer mark;

    @Column(name = "model_id")
    Long modelId;

    @Column(name = "create_time")
    String time;
}
