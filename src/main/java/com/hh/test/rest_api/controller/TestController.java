package com.hh.test.rest_api.controller;

import com.hh.test.rest_api.model.request.TestRequestDTO;
import com.hh.test.rest_api.model.response.TestResponseDTO;
import com.hh.test.rest_api.service.TestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;


    @GetMapping("/symbolsFrequency")
    public ResponseEntity<TestResponseDTO> symbolsFrequency(@Valid @RequestBody TestRequestDTO request) {
        TestResponseDTO response = new TestResponseDTO(testService.getSymbolsFrequency(request.getStr()));
        return ResponseEntity.ok(response);
    }

}
