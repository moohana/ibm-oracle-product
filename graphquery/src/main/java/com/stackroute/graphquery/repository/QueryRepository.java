package com.stackroute.graphquery.repository;

import com.stackroute.graphquery.domain.Answer;
import com.stackroute.graphquery.domain.Questions;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends Neo4jRepository<Questions, Long> {

    /*
     Displays the set of questions and corresponding answers for that questions
     */
    @Query("match (c:Concept{name:({concept})})<-[:QUESTION_OF]-(q:Questions{name:({question})})<-[:ANSWER_OF]-(a:Answer) return a,q")
    Iterable<Answer> solution(String concept, String question);

    /*
        creates nodes for question and answer and also creates relationships
        between concept,question and answer
     */

    @Query("MATCH (c:Concept) where c.name=({concept}) \n" +
            "CREATE (a:Answer {answer:({answer}),concept:({concept})} )\n" +
            "CREATE (q:Questions {name:({question}),concept:({concept})} )\n" +
            "CREATE (a)-[r1:ANSWER_OF]->(q) \n" +
            "CREATE (q)-[r2:QUESTION_OF]->(c) return r1,r2,a,q,c")
    Iterable<Questions> createNodesAndRelationships(String concept, String question, String answer);

}
