package controllerTests;
import com.lowes3.osp.controller.QuestionController;
import com.lowes3.osp.entity.Question;
import com.lowes3.osp.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class QuestionControllerTest {
	 private MockMvc mockMvc;

	    @Mock
	    private QuestionService questionService;

	    @InjectMocks
	    private QuestionController questionController;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
	    }

	    @Test
	    void saveQuestion() throws Exception {
	        Question question = new Question();
	        question.setQuestionId(1);
	        question.setQuestionType("Type 1");
	        question.setQuestionDescription("Description 1");

	        when(questionService.saveQuestion(any(Question.class))).thenReturn(question);

	        mockMvc.perform(post("/saveQuestion")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"questionId\": 1, \"questionType\": \"Type 1\", \"questionDescription\": \"Description 1\"}"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.questionId").value(1))
	                .andExpect(jsonPath("$.questionType").value("Type 1"))
	                .andExpect(jsonPath("$.questionDescription").value("Description 1"));

	        verify(questionService, times(1)).saveQuestion(any(Question.class));
	    }

	    @Test
	    void getQuestionById() throws Exception {
	        Question question = new Question();
	        question.setQuestionId(1);
	        question.setQuestionType("Type 1");
	        question.setQuestionDescription("Description 1");

	        when(questionService.getQuestionById(1)).thenReturn(question);

	        mockMvc.perform(get("/getQuestion/1"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.questionId").value(1))
	                .andExpect(jsonPath("$.questionType").value("Type 1"))
	                .andExpect(jsonPath("$.questionDescription").value("Description 1"));

	        verify(questionService, times(1)).getQuestionById(1);
	    }

	    @Test
	    void updateQuestion() throws Exception {
	        Question question = new Question();
	        question.setQuestionId(1);
	        question.setQuestionType("Type 1");
	        question.setQuestionDescription("Description 1");

	        when(questionService.updateQuestion(any(Question.class))).thenReturn(question);

	        mockMvc.perform(put("/updateQuestion")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"questionId\": 1, \"questionType\": \"Type 1\", \"questionDescription\": \"Description 1\"}"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.questionId").value(1))
	                .andExpect(jsonPath("$.questionType").value("Type 1"))
	                .andExpect(jsonPath("$.questionDescription").value("Description 1"));

	        verify(questionService, times(1)).updateQuestion(any(Question.class));
	    }

	    @Test
	    void deleteQuestionById() throws Exception {
	        when(questionService.deleteQuestionById(1)).thenReturn("Deleted the question.");

	        mockMvc.perform(delete("/deleteQuestion/1"))
	                .andExpect(status().isOk())
	                .andExpect(content().string("Deleted the question."));

	        verify(questionService, times(1)).deleteQuestionById(1);
	    }
}
