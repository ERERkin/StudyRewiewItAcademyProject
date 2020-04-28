package it.academy.StudyRewiewItAcademyProject.entity;

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
@Table(name = "st_commentable_entity_column_link")
public class CommentableEntityColumnLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @Column(name = "column_entity_id")
    CommentableEntity columnEntity;

    @ManyToOne
    @Column(name = "entity_id")
    CommentableEntity entity;
}
