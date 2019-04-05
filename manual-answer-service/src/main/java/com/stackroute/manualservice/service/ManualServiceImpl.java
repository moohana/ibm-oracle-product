package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.exception.QueryNotFoundException;
import com.stackroute.manualservice.repository.ManualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService {

    private ManualRepository manualRepository;

    //Declaration

    private final Logger logger = LoggerFactory.getLogger(ManualServiceImpl.class);

    @Autowired
    public ManualServiceImpl(ManualRepository manualRepository) {

        this.manualRepository = manualRepository;
    }

    // Implemeneting Methods

    //1. Save user met2hod

    @Override
    public Query saveQuestion(Query query) {
        logger.info("Save User:" + query);

        Query saveQuery = manualRepository.save(query);
        return query;

    }

    // 2. Get list of questions
    @Override
    public List<Query> getListOfQuestions() {

        List<Query> userQueryList = (List<Query>) manualRepository.findAll();

        return userQueryList;
    }

    //3. Update Question

    @Override
    public Query updateQuestion(Query query) throws QueryNotFoundException {


        if (manualRepository.existsById(query.getId())) {

            return manualRepository.save(query);

        }
        else {
            throw new QueryNotFoundException("Query Not Found");
        }
    }

    // 4. Delete The user Question

    @Override
    public Query deleteQuestion(String questionId) {
        Query deletedQuery = (Query) manualRepository.findById(questionId).get();
        manualRepository.deleteById(questionId);
        return deletedQuery;
    }

    //5.Get Query by Topic name

    @Override
    public List<Query> getQuestionsByTopicName(String topic_name) {

        List<Query> queryList = manualRepository.searchByTopicName(topic_name);
        return queryList;
    }

}
