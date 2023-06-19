package serviceTests;

import com.lowes3.osp.dao.QuestionRepository;
import com.lowes3.osp.entity.Question;
import com.lowes3.osp.service.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class QuestionServiceImplTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveQuestion() {
        // Arrange
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionType("Type 1");
        when(questionRepository.save(any(Question.class))).thenReturn(question);

        // Act
        Question savedQuestion = questionService.saveQuestion(question);

        // Assert
        assertNotNull(savedQuestion);
        assertEquals(question, savedQuestion);
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void getQuestionById_existingQuestionId_shouldReturnQuestion() {
        // Arrange
        Integer questionId = 1;
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionType("Type 1");
        when(questionRepository.findById(questionId)).thenReturn(Optional.of(question));

        // Act
        Question retrievedQuestion = questionService.getQuestionById(questionId);

        // Assert
        assertNotNull(retrievedQuestion);
        assertEquals(question, retrievedQuestion);
        verify(questionRepository, times(1)).findById(questionId);
    }

    @Test
    void getQuestionById_nonExistingQuestionId_shouldReturnNull() {
        // Arrange
        Integer questionId = 2;
        when(questionRepository.findById(questionId)).thenReturn(Optional.empty());

        // Act
        Question retrievedQuestion = questionService.getQuestionById(questionId);

        // Assert
        assertNull(retrievedQuestion);
        verify(questionRepository, times(1)).findById(questionId);
    }

    @Test
    void updateQuestion_existingQuestion_shouldReturnUpdatedQuestion() {
        // Arrange
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionType("Type 1");
        when(questionRepository.existsById(anyInt())).thenReturn(true);
        when(questionRepository.save(any(Question.class))).thenReturn(question);

        // Act
        Question updatedQuestion = questionService.updateQuestion(question);

        // Assert
        assertNotNull(updatedQuestion);
        assertEquals(question, updatedQuestion);
        verify(questionRepository, times(1)).existsById(question.getQuestionId());
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void updateQuestion_nonExistingQuestion_shouldReturnNull() {
        // Arrange
        Question question = new Question();
        question.setQuestionId(2);
        question.setQuestionType("Type 2");
        when(questionRepository.existsById(anyInt())).thenReturn(false);

        // Act
        Question updatedQuestion = questionService.updateQuestion(question);

        // Assert
        assertNull(updatedQuestion);
        verify(questionRepository, times(1)).existsById(question.getQuestionId());
        verify(questionRepository, never()).save(any(Question.class));
    }

    @Test
    void deleteQuestionById_existingQuestionId_shouldReturnSuccessMessage() {
        // Arrange
        Integer questionId = 1;
        when(questionRepository.findById(questionId)).thenReturn(Optional.of(new Question()));

        // Act
        String result = questionService.deleteQuestionById(questionId);

        // Assert
        assertEquals("Deleted the question.", result);
        verify(questionRepository, times(1)).findById(questionId);
        verify(questionRepository, times(1)).deleteById(questionId);
    }

    @Test
    void deleteQuestionById_nonExistingQuestionId_shouldReturnNotFoundMessage() {
        // Arrange
        Integer questionId = 2;
        when(questionRepository.findById(questionId)).thenReturn(Optional.empty());

        // Act
        String result = questionService.deleteQuestionById(questionId);

        // Assert
        assertEquals("Could not find question by Id.", result);
        verify(questionRepository, times(1)).findById(questionId);
        verify(questionRepository, never()).deleteById(anyInt());
    }
}
