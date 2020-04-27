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
@Table(name = "st_commentable_entity_column")
public class CommentableEntityColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "info_type")
    String infoType;

    @Column(name = "info")
    String info;

    @ManyToOne
    @Column(name = "entity_id")
    CommentableEntity entity;
}
