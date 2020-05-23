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
@Table(name = "st_commentable_entity_added_column")
public class CommentableEntityAddedColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "column_name")
    String columnName;

    @Column(name = "info")
    String inf;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    CommentableEntity addedColumnEntity;
}
