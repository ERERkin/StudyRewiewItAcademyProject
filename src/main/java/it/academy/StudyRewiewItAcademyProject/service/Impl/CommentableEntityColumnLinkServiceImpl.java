package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityColumnLink;
import it.academy.StudyRewiewItAcademyProject.repos.CommentableEntityColumnLinkRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityColumnLinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommentableEntityColumnLinkServiceImpl implements CommentableEntityColumnLinkService {
    @Autowired
    private CommentableEntityColumnLinkRepo commentableEntityColumnLinkRepo;
    @Override
    public CommentableEntityColumnLink getById(Long id) {
        Optional<CommentableEntityColumnLink> commentableEntityColumnLink =
                commentableEntityColumnLinkRepo.findById(id);
        return commentableEntityColumnLink.get();
    }

    @Override
    public List<CommentableEntityColumnLink> getAll() {
        return commentableEntityColumnLinkRepo.findAll();
    }

    @Override
    public CommentableEntityColumnLink save(CommentableEntityColumnLink item) {
        return commentableEntityColumnLinkRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        commentableEntityColumnLinkRepo.deleteById(id);
    }
}
