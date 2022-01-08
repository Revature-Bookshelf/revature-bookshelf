package com.revature.revaturebookshelfjava.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InvalidSearchPropertyException extends Exception{

    private String message;
}

//THIS IS A CUSTOM EXCEPTION USED IN THE CASE OF A SEARCH FAILURE - USED ONLY IN THE SEARCH FUNCTIONALITY