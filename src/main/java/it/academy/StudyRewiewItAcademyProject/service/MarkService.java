package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.Mark;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MarkService extends BaseService<Mark> {
    @Override
    Mark getById(Long id);

    @Override
    List<Mark> getAll();

    @Override
    Mark save(Mark item);

    @Override
    void delete(Long id);
}
