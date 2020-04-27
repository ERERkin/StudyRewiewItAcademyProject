package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentableEntityColumnRepo extends JpaRepository<CommentableEntityColumn, Long> {
}
