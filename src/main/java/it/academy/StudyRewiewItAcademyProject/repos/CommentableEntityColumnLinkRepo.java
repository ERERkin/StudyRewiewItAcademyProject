package it.academy.StudyRewiewItAcademyProject.repos;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumnLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentableEntityColumnLinkRepo extends JpaRepository<CommentableEntityColumnLink, Long> {
}
