package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.Review;
import it.academy.StudyRewiewItAcademyProject.models.Model;
import it.academy.StudyRewiewItAcademyProject.models.ReviewModel;
import it.academy.StudyRewiewItAcademyProject.models.SuperReviewModel;
import it.academy.StudyRewiewItAcademyProject.repos.ReviewRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import it.academy.StudyRewiewItAcademyProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;
    @Autowired
    CommentableEntityService commentableEntityService;

    @Override
    public Review getById(Long id) {
        return reviewRepo.findById(id).get();
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

    @Override
    public List<ReviewModel> getAllByEntity(Long id) throws ParseException {
        List<ReviewModel> reviewModels = new ArrayList<>();
        List<Review> reviews = reviewRepo.getAllByCommentableEntity(id);
        for(Review r : reviews){
            String s = commentableEntityService.getType(id);
            if(s.equals("Department"))
            reviewModels.add(ReviewModel.builder()
                    .id(r.getId())
                    .review(r.getReview())
                    .mark(r.getMark())
                    //.model(commentableEntityService.getDepartment(r.getId()))
                    .build());
            else if(s.equals("Employee"))
                reviewModels.add(ReviewModel.builder()
                        .id(r.getId())
                        .review(r.getReview())
                        .mark(r.getMark())
                        //.model(commentableEntityService.getEmployee(r.getId()))
                        .build());
            else if(s.equals("University"))
                reviewModels.add(ReviewModel.builder()
                        .id(r.getId())
                        .review(r.getReview())
                        .mark(r.getMark())
                        //.model(commentableEntityService.getUniversity(r.getId()))
                        .build());
            else if(s.equals("Faculty"))
                reviewModels.add(ReviewModel.builder()
                        .id(r.getId())
                        .review(r.getReview())
                        .mark(r.getMark())
                        //.model(commentableEntityService.getFaculty(r.getId()))
                        .build());
            else if(s.equals("Speciality"))
                reviewModels.add(ReviewModel.builder()
                        .id(r.getId())
                        .review(r.getReview())
                        .mark(r.getMark())
                        //.model(commentableEntityService.getSpeciality(r.getId()))
                        .build());
        }
        return reviewModels;
    }

    @Override
    public SuperReviewModel getSuperMReviewModel(Long id, String type) throws ParseException {
        Model model = null;
        if(type.equals("Department")){
            model = commentableEntityService.getDepartment(id);
        }
        else if(type.equals("Employee")){
            model = commentableEntityService.getEmployee(id);
        }
        else if(type.equals("University")){
            model = commentableEntityService.getUniversity(id);
        }
        else if(type.equals("Faculty")){
            model = commentableEntityService.getFaculty(id);
        }
        else if(type.equals("Speciality")){
            model = commentableEntityService.getSpeciality(id);
        }
        List<ReviewModel> reviewModels = getAllByEntity(id);
        return SuperReviewModel.builder()

                .model(model)
                .reviewModels(reviewModels)
                .build();
    }
}
