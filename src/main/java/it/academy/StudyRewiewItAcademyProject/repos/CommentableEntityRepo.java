package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.Comment;
import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentableEntityRepo extends JpaRepository<CommentableEntity, Long> {
}
