package com.stackroute.queryautocorrector.controller;

import com.stackroute.queryautocorrector.corrector.QueryAutoCorrector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class QueryCorrectorController {

    @GetMapping("/getCorrectedQuery/{query}")
    public String getCorrectedQuery(@PathVariable("query") String query) throws IOException {
        String correctedQuery = QueryAutoCorrector.correctQuery(query);
        return correctedQuery;
    }
}
