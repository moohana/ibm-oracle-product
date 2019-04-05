package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.exception.QueryNotFoundException;
import com.stackroute.manualservice.repository.ManualRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ManualServiceImplTest {
    private Query query;
    @Mock
    private ManualRepository manualRepository;
    @InjectMocks
    private ManualServiceImpl manualService;
    private ArrayList list;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        query = new Query();
        query.setQuestion("abcd");
        query.setAnswer("tyu");
        query.setId("1");
        list = new ArrayList();
        list.add(query);

    }

    @Test
    public void saveQuestion() throws QueryNotFoundException {

        when(manualRepository.save((Query) any())).thenReturn(query);
        Query saveQuery = manualService.saveQuestion(query);
        Assert.assertEquals(query, saveQuery);

        //verify here verifies that userRepository save method is only called once
        verify(manualRepository, times(1)).save(query);

    }


//        when(manualRepository.save((Query)ArgumentMatchers.any())).thenReturn(query);
//        Query saveQuery=manualService.saveQuestion(query);
//        Assert.assertEquals(query.saveQuery);
//        verify(manualRepository,times(1)).save(query);


    @Test
    public void getListOfQuestions() {
        manualRepository.save(query);
        //  stubbing the mock to return specific data
        when(manualRepository.findAll()).thenReturn(anyList());
        List<Query> userQueryList = manualService.getListOfQuestions();
        Assert.assertEquals(anyList(), userQueryList);
    }

    @Test
    public void updateQuestion() {
    }

    @Test
    public void deleteQuestion() {
        manualService.deleteQuestion("9");
        verify(manualRepository, times(1)).deleteById("9");
    }

    @Test
    public void getQuestionsByTopicName() {
        when(manualRepository.searchByTopicName("abcd")).thenReturn(anyList());
        List<Query> foundQuestion = manualService.getQuestionsByTopicName("abcd");
        Assert.assertEquals(query,foundQuestion);
        }
    }

