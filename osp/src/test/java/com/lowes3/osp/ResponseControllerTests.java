package com.lowes3.osp;

import com.lowes3.osp.controller.ResponseController;
import com.lowes3.osp.entity.Response;
import com.lowes3.osp.service.ResponseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ResponseControllerTests {

    private MockMvc mockMvc;

    @Mock
    private ResponseService responseService;

    @InjectMocks
    private ResponseController responseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(responseController).build();
    }

    @Test
    void saveResponse() throws Exception {
    	Response response1 = new Response(1, "Response 1", null, null);
    	Response response2 = new Response(2, "Response 2", null, null);
        when(responseService.saveResponse(any(Response.class))).thenReturn(response1);

        mockMvc.perform(post("/saveResponse")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"responseId\": 1, \"responseDetails\": \"Response 1\"}," +
                        "{\"responseId\": 2, \"responseDetails\": \"Response 2\"}]"))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully Responded"));

        verify(responseService, times(2)).saveResponse(any(Response.class));
    }

    @Test
    void getResponseById() throws Exception {
        Response response = new Response(1, "Response 1", null, null);
        when(responseService.getResponseById(1)).thenReturn(response);

        mockMvc.perform(get("/getResponse/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseId").value(1))
                .andExpect(jsonPath("$.responseDetails").value("Response 1"));

        verify(responseService, times(1)).getResponseById(1);
    }

    @Test
    void updateResponse() throws Exception {
    	Response response = new Response(1, "Response 1", null, null);
        when(responseService.updateResponse(any(Response.class))).thenReturn(response);

        mockMvc.perform(put("/updateResponse")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"responseId\": 1, \"responseDetails\": \"Response 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseId").value(1))
                .andExpect(jsonPath("$.responseDetails").value("Response 1"));

        verify(responseService, times(1)).updateResponse(any(Response.class));
    }

    @Test
    void deleteResponseById() throws Exception {
        when(responseService.deleteResponseById(1)).thenReturn("Deleted the response.");

        mockMvc.perform(delete("/deleteResponse/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted the response."));

        verify(responseService, times(1)).deleteResponseById(1);
    }
}
