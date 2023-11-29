package com.hh.test.rest_api.controller;

import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @Nullable HttpHeaders headers,
                                                                  @Nullable HttpStatusCode status,
                                                                  @Nullable WebRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fe : ex.getFieldErrors()) {

            stringBuilder.append(fe.getField());
            stringBuilder.append(" - ");
            stringBuilder.append(fe.getDefaultMessage());
            stringBuilder.append(". ");
        }
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                stringBuilder.toString());
        problemDetail.setTitle("Validation Error");


        return ResponseEntity.badRequest().body(problemDetail);
    }
}
