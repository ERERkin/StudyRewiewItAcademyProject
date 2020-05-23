package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityAddedColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentableEntityAddedColumnRepo  extends JpaRepository<CommentableEntityAddedColumn, Long> {
    @Query("SELECT ceal FROM CommentableEntityAddedColumn ceal where ceal.addedColumnEntity.id = :idEntity")
    List<CommentableEntityAddedColumn> findAllByModel(Long idEntity);
}
