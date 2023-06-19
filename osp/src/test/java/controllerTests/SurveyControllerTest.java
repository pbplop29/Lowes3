package controllerTests;

import com.lowes3.osp.controller.SurveyController;
import com.lowes3.osp.entity.Survey;
import com.lowes3.osp.service.SurveyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SurveyControllerTest {
    private MockMvc mockMvc;

    @Mock
    private SurveyService surveyService;

    @InjectMocks
    private SurveyController surveyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(surveyController).build();
    }

    @Test
    void saveSurvey() throws Exception {
        Survey survey = new Survey();
        survey.setSurveyId(1);
        survey.setSurveyTitle("Title 1");
        survey.setSurveyDescription("Description 1");

        when(surveyService.saveSurvey(any(Survey.class))).thenReturn(survey);

        mockMvc.perform(post("/saveSurvey")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"surveyId\": 1, \"surveyTitle\": \"Title 1\", \"surveyDescription\": \"Description 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surveyId").value(1))
                .andExpect(jsonPath("$.surveyTitle").value("Title 1"))
                .andExpect(jsonPath("$.surveyDescription").value("Description 1"));

        verify(surveyService, times(1)).saveSurvey(any(Survey.class));
    }

    @Test
    void getSurveyById() throws Exception {
        Survey survey = new Survey();
        survey.setSurveyId(1);
        survey.setSurveyTitle("Title 1");
        survey.setSurveyDescription("Description 1");

        when(surveyService.getSurveyById(1)).thenReturn(survey);

        mockMvc.perform(get("/getSurvey/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surveyId").value(1))
                .andExpect(jsonPath("$.surveyTitle").value("Title 1"))
                .andExpect(jsonPath("$.surveyDescription").value("Description 1"));

        verify(surveyService, times(1)).getSurveyById(1);
    }

    @Test
    void getSurveys() throws Exception {
        List<Survey> surveys = new ArrayList<>();
        Survey survey1 = new Survey();
        survey1.setSurveyId(1);
        survey1.setSurveyTitle("Title 1");
        survey1.setSurveyDescription("Description 1");
        surveys.add(survey1);

        Survey survey2 = new Survey();
        survey2.setSurveyId(2);
        survey2.setSurveyTitle("Title 2");
        survey2.setSurveyDescription("Description 2");
        surveys.add(survey2);

        when(surveyService.getSurveys()).thenReturn(surveys);

        mockMvc.perform(get("/getSurveys"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].surveyId").value(1))
                .andExpect(jsonPath("$[0].surveyTitle").value("Title 1"))
                .andExpect(jsonPath("$[0].surveyDescription").value("Description 1"))
                .andExpect(jsonPath("$[1].surveyId").value(2))
                .andExpect(jsonPath("$[1].surveyTitle").value("Title 2"))
                .andExpect(jsonPath("$[1].surveyDescription").value("Description 2"));

        verify(surveyService, times(1)).getSurveys();
    }

    @Test
    void updateSurvey() throws Exception {
        Survey survey = new Survey();
        survey.setSurveyId(1);
        survey.setSurveyTitle("Title 1");
        survey.setSurveyDescription("Description 1");

        when(surveyService.updateSurvey(any(Survey.class))).thenReturn(survey);

        mockMvc.perform(put("/updateSurvey")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"surveyId\": 1, \"surveyTitle\": \"Title 1\", \"surveyDescription\": \"Description 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surveyId").value(1))
                .andExpect(jsonPath("$.surveyTitle").value("Title 1"))
                .andExpect(jsonPath("$.surveyDescription").value("Description 1"));

        verify(surveyService, times(1)).updateSurvey(any(Survey.class));
    }

    @Test
    void deleteSurveyById() throws Exception {
        when(surveyService.deleteSurveyById(1)).thenReturn("Deleted the Survey.");

        mockMvc.perform(delete("/deleteSurvey/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted the Survey."));

        verify(surveyService, times(1)).deleteSurveyById(1);
    }
}
