package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.Mark;
import it.academy.StudyRewiewItAcademyProject.repos.MarkRepo;
import it.academy.StudyRewiewItAcademyProject.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    MarkRepo markRepo;

    @Override
    public Mark getById(Long id) {
        return markRepo.findById(id).get();
    }

    @Override
    public List<Mark> getAll() {
        return markRepo.findAll();
    }

    @Override
    public Mark save(Mark item) {
        return markRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        markRepo.deleteById(id);
    }
}
