package it.academy.StudyRewiewItAcademyProject.service;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityAddedColumn;
import it.academy.StudyRewiewItAcademyProject.models.AddedColumnModel;

import java.text.ParseException;
import java.util.List;

public interface CommentableEntityAddedColumnService extends BaseService<CommentableEntityAddedColumn>{
    AddedColumnModel getModelById(Long id) throws ParseException;

    List<AddedColumnModel> getAllModel() throws ParseException;

    List<AddedColumnModel> getAllByModel(Long id) throws ParseException;

    AddedColumnModel saveModel(CommentableEntityAddedColumn commentableEntityAddedColumn) throws ParseException;


}
