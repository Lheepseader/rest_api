package com.hh.test.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hh.test.rest_api.controller.TestController;
import com.hh.test.rest_api.model.request.TestRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiApplicationTests {

    @Autowired
    private TestController testController;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnBadRequestWithErrorMessage() throws Exception {
        TestRequestDTO testRequestDTO = new TestRequestDTO();
        String result = mvc.perform(MockMvcRequestBuilders.get("/symbolsFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }

    @Test
    public void shouldReturnOkWithAnswer() throws Exception {
        TestRequestDTO testRequestDTO = new TestRequestDTO("aaabbbbcccdd");
        String result = mvc.perform(MockMvcRequestBuilders.get("/symbolsFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }

    @Test
    public void shouldReturnOkWithEmpty() throws Exception {
        TestRequestDTO testRequestDTO = new TestRequestDTO("");
        String result = mvc.perform(MockMvcRequestBuilders.get("/symbolsFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }


}
