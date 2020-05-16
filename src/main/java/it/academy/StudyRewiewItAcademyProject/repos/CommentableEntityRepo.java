package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentableEntityRepo extends JpaRepository<CommentableEntity, Long> {
    @Query("SELECT ce FROM CommentableEntity ce where ce.type = :type")
    List<CommentableEntity> findAllByType(String type);

    @Query("SELECT count(ce) FROM CommentableEntity ce where ce.id = :id")
    Long findCount(Long id);
}
