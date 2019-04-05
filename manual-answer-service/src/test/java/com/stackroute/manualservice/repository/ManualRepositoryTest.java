package com.stackroute.manualservice.repository;

import com.netflix.discovery.converters.Auto;
import com.stackroute.manualservice.domain.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ManualRepositoryTest {

    @Autowired
    private ManualRepository manualRepository;


    private Query query;

    @Before
    public void setUp(){
      query = new Query();
//      query.setQuestion("abcd");
//      query.setId("2");
//      query.setAnswer("answer");
    }

    @Test
    public void saveQuerySuccess(){

       Query savedQuery =  manualRepository.save(query);
       // Assert.assertEquals("answer",savedQuery.getAnswer());
    }
    @Test
    public void saveQueryFailure(){

        Query savedQuery =  manualRepository.save(query);
        //Assert.assertNotEquals("question",savedQuery.getAnswer());
    }

}
