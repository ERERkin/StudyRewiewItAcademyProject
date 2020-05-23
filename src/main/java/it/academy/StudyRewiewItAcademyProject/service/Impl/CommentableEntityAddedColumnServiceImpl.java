package it.academy.StudyRewiewItAcademyProject.service.Impl;

import it.academy.StudyRewiewItAcademyProject.entity.CommentableEntityAddedColumn;
import it.academy.StudyRewiewItAcademyProject.models.AddedColumnModel;
import it.academy.StudyRewiewItAcademyProject.repos.CommentableEntityAddedColumnRepo;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityAddedColumnService;
import it.academy.StudyRewiewItAcademyProject.service.CommentableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentableEntityAddedColumnServiceImpl implements CommentableEntityAddedColumnService{
    @Autowired
    CommentableEntityAddedColumnRepo commentableEntityAddedColumnRepo;
    @Autowired
    CommentableEntityService commentableEntityService;

    @Override
    public CommentableEntityAddedColumn getById(Long id) {
        return commentableEntityAddedColumnRepo.findById(id).get();
    }

    @Override
    public List<CommentableEntityAddedColumn> getAll() {
        return commentableEntityAddedColumnRepo.findAll();
    }

    @Override
    public CommentableEntityAddedColumn save(CommentableEntityAddedColumn item) {
        return commentableEntityAddedColumnRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        commentableEntityAddedColumnRepo.deleteById(id);
    }

    @Override
    public AddedColumnModel getModelById(Long id) throws ParseException {
        CommentableEntityAddedColumn commentableEntityAddedColumn
                = commentableEntityAddedColumnRepo.findById(id).get();
        String s = commentableEntityService.getType(
                commentableEntityAddedColumn
                        .getAddedColumnEntity()
                        .getId());
        AddedColumnModel addedColumnModel = AddedColumnModel.builder()
                .id(id)
                .columnName(commentableEntityAddedColumn.getColumnName())
                .inf(commentableEntityAddedColumn.getInf())
                .modelId(commentableEntityAddedColumn.getAddedColumnEntity().getId())
                .build();
        return addedColumnModel;
    }

    @Override
    public List<AddedColumnModel> getAllModel() throws ParseException {
        List<CommentableEntityAddedColumn> commentableEntityAddedColumns =
                commentableEntityAddedColumnRepo.findAll();
        List<AddedColumnModel> addedColumnModels = new ArrayList<>();
        for(CommentableEntityAddedColumn c : commentableEntityAddedColumns){
            addedColumnModels.add(getModelById(c.getId()));
        }
        return addedColumnModels;
    }

    @Override
    public List<AddedColumnModel> getAllByModel(Long id) throws ParseException {
        List<CommentableEntityAddedColumn> commentableEntityAddedColumns =
                commentableEntityAddedColumnRepo.findAllByModel(id);
        List<AddedColumnModel> addedColumnModels = new ArrayList<>();
        for(CommentableEntityAddedColumn c : commentableEntityAddedColumns){
            addedColumnModels.add(getModelById(c.getId()));
        }
        return addedColumnModels;
    }

    @Override
    public AddedColumnModel saveModel(CommentableEntityAddedColumn commentableEntityAddedColumn) throws ParseException {
        CommentableEntityAddedColumn c = save(commentableEntityAddedColumn);
        AddedColumnModel addedColumnModel = getModelById(c.getId());
        return addedColumnModel;
    }
}
