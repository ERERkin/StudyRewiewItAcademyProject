package it.academy.StudyRewiewItAcademyProject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "st_commentable_entity")
public class CommentableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "type")
    String type;

    @OneToMany(mappedBy = "entity", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    List<CommentableEntityColumn> columns;

    @OneToMany(mappedBy = "columnEntity", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    List<CommentableEntityColumnLink> linkColumns;
}
