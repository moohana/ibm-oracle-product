package com.stackroute.manualservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.exception.QueryNotFoundException;
import com.stackroute.manualservice.service.ManualServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ManualControllerTest {


        @Autowired
        private MockMvc mockMvc;
        private Query query;
       @InjectMocks
       private ManualServiceImpl manualService;
        @InjectMocks
        private ManualController manualController;

        private List<Query> list = null;
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(manualController).build();
        query = new Query();
        query.setId("1");
        query.setQuestion("What is a docker");
        query.setAnswer("docker is a container");
        list = new ArrayList();
        list.add(query);


    }

        @Test
    public void getAllQuestions() throws Exception{
            when(manualService.getListOfQuestions()).thenReturn(list);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(query)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());

        }


    @Test
    public void updateQuestion() throws Exception {
        when(manualService.updateQuestion(query)).thenReturn(query);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(query)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }





}

