package serviceTests;

import com.lowes3.osp.dao.SurveyRepository;
import com.lowes3.osp.entity.Survey;
import com.lowes3.osp.service.SurveyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SurveyServiceImplTest {
    @Mock
    private SurveyRepository surveyRepository;

    @InjectMocks
    private SurveyServiceImpl surveyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSurvey() {
        // Arrange
        Survey survey = new Survey();
        survey.setSurveyId(1);
        survey.setSurveyTitle("Survey Title");
        when(surveyRepository.save(any(Survey.class))).thenReturn(survey);

        // Act
        Survey savedSurvey = surveyService.saveSurvey(survey);

        // Assert
        assertNotNull(savedSurvey);
        assertEquals(survey, savedSurvey);
        verify(surveyRepository, times(1)).save(survey);
    }

    @Test
    void getSurveyById_existingSurveyId_shouldReturnSurvey() {
        // Arrange
        Integer surveyId = 1;
        Survey survey = new Survey();
        survey.setSurveyId(1);
        survey.setSurveyTitle("Survey Title");
        when(surveyRepository.findById(surveyId)).thenReturn(Optional.of(survey));

        // Act
        Survey retrievedSurvey = surveyService.getSurveyById(surveyId);

        // Assert
        assertNotNull(retrievedSurvey);
        assertEquals(survey, retrievedSurvey);
        verify(surveyRepository, times(1)).findById(surveyId);
    }

    @Test
    void getSurveyById_nonExistingSurveyId_shouldReturnNull() {
        // Arrange
        Integer surveyId = 2;
        when(surveyRepository.findById(surveyId)).thenReturn(Optional.empty());

        // Act
        Survey retrievedSurvey = surveyService.getSurveyById(surveyId);

        // Assert
        assertNull(retrievedSurvey);
        verify(surveyRepository, times(1)).findById(surveyId);
    }

    @Test
    void updateSurvey_existingSurvey_shouldReturnUpdatedSurvey() {
        // Arrange
        Survey survey = new Survey();
        survey.setSurveyId(1);
        survey.setSurveyTitle("Survey Title");
        when(surveyRepository.existsById(anyInt())).thenReturn(true);
        when(surveyRepository.save(any(Survey.class))).thenReturn(survey);

        // Act
        Survey updatedSurvey = surveyService.updateSurvey(survey);

        // Assert
        assertNotNull(updatedSurvey);
        assertEquals(survey, updatedSurvey);
        verify(surveyRepository, times(1)).existsById(survey.getSurveyId());
        verify(surveyRepository, times(1)).save(survey);
    }

    @Test
    void updateSurvey_nonExistingSurvey_shouldReturnNull() {
        // Arrange
        Survey survey = new Survey();
        survey.setSurveyId(2);
        survey.setSurveyTitle("Survey Title");
        when(surveyRepository.existsById(anyInt())).thenReturn(false);

        // Act
        Survey updatedSurvey = surveyService.updateSurvey(survey);

        // Assert
        assertNull(updatedSurvey);
        verify(surveyRepository, times(1)).existsById(survey.getSurveyId());
        verify(surveyRepository, never()).save(any(Survey.class));
    }

    @Test
    void deleteSurveyById_existingSurveyId_shouldReturnSuccessMessage() {
        // Arrange
        Integer surveyId = 1;
        when(surveyRepository.findById(surveyId)).thenReturn(Optional.of(new Survey()));

        // Act
        String result = surveyService.deleteSurveyById(surveyId);

        // Assert
        assertEquals("Deleted the Survey.", result);
        verify(surveyRepository, times(1)).findById(surveyId);
        verify(surveyRepository, times(1)).deleteById(surveyId);
    }

    @Test
    void deleteSurveyById_nonExistingSurveyId_shouldReturnNotFoundMessage() {
        // Arrange
        Integer surveyId = 2;
        when(surveyRepository.findById(surveyId)).thenReturn(Optional.empty());

        // Act
        String result = surveyService.deleteSurveyById(surveyId);

        // Assert
        assertEquals("Could not find Survey by Id.", result);
        verify(surveyRepository, times(1)).findById(surveyId);
        verify(surveyRepository, never()).deleteById(anyInt());
    }

    @Test
    void getSurveys_shouldReturnListOfSurveys() {
        // Arrange
        List<Survey> surveys = new ArrayList<>();
        surveys.add(new Survey(1, "Survey 1", "Description 1", new ArrayList<>()));
        surveys.add(new Survey(2, "Survey 2", "Description 2", new ArrayList<>()));
        when(surveyRepository.findAll()).thenReturn(surveys);

        // Act
        List<Survey> retrievedSurveys = surveyService.getSurveys();

        // Assert
        assertNotNull(retrievedSurveys);
        assertEquals(surveys.size(), retrievedSurveys.size());
        assertEquals(surveys.get(0), retrievedSurveys.get(0));
        assertEquals(surveys.get(1), retrievedSurveys.get(1));
        verify(surveyRepository, times(1)).findAll();
    }
}
