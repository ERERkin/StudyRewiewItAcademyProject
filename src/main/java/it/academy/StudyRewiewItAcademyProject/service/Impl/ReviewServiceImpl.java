package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.repos.ReviewRepo;
import it.academy.StudyRewiewItAcademyProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public Review getById(Long id) {
        return reviewRepo.getOne(id);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review save(Review item) {
        return reviewRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }
}
