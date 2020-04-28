package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService extends BaseService<Review> {
    @Override
    Review getById(Long id);

    @Override
    List<Review> getAll();

    @Override
    Review save(Review item);

    @Override
    void delete(Long id);
}
