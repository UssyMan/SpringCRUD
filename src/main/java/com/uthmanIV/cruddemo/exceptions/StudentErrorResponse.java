package com.uthmanIV.cruddemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentErrorResponse {
    private int statusCode;
    private String message;
    private long timeStamp;
}
