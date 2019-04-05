package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.exception.QueryAlreadyExistException;
import com.stackroute.manualservice.exception.QueryNotFoundException;

import java.util.List;

public interface ManualService {

    //Save user
    public Query saveQuestion(Query query);

    //get List of Question
    public List<Query> getListOfQuestions();


    //Update Query
    public Query updateQuestion(Query query) throws QueryNotFoundException;

    //Delete Query
    public Query deleteQuestion(String queryId);


    //Get Query by Topic name

    public List<Query> getQuestionsByTopicName(String name);
}
