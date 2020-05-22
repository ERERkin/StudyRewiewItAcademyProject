package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.models.ReviewModel;
import it.academy.StudyRewiewItAcademyProject.models.SuperCommentModel;
import it.academy.StudyRewiewItAcademyProject.models.SuperReviewModel;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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

    List<ReviewModel> getAllByEntity(Long id) throws ParseException;

    SuperReviewModel getSuperMReviewModel(Long id, String type) throws ParseException;
}
