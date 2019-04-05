package com.stackroute.botservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {

    private Query query;
    private Status status;

    @Override
    public String toString() {
        return "UserQuery{" +
                "query=" + query +
                ", status=" + status +
                '}';
    }
}
