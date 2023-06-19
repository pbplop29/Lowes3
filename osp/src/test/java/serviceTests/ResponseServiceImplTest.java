package serviceTests;

import com.lowes3.osp.dao.ResponseRepository;
import com.lowes3.osp.entity.Response;
import com.lowes3.osp.service.ResponseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ResponseServiceImplTest {
    @Mock
    private ResponseRepository responseRepository;

    @InjectMocks
    private ResponseServiceImpl responseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveResponse() {
        // Arrange
        Response response = new Response();
        response.setResponseId(1);
        response.setResponseDetails("Details 1");
        when(responseRepository.save(any(Response.class))).thenReturn(response);

        // Act
        Response savedResponse = responseService.saveResponse(response);

        // Assert
        assertNotNull(savedResponse);
        assertEquals(response, savedResponse);
        verify(responseRepository, times(1)).save(response);
    }

    @Test
    void getResponseById_existingResponseId_shouldReturnResponse() {
        // Arrange
        Integer responseId = 1;
        Response response = new Response();
        response.setResponseId(1);
        response.setResponseDetails("Details 1");
        when(responseRepository.findById(responseId)).thenReturn(Optional.of(response));

        // Act
        Response retrievedResponse = responseService.getResponseById(responseId);

        // Assert
        assertNotNull(retrievedResponse);
        assertEquals(response, retrievedResponse);
        verify(responseRepository, times(1)).findById(responseId);
    }

    @Test
    void getResponseById_nonExistingResponseId_shouldReturnNull() {
        // Arrange
        Integer responseId = 2;
        when(responseRepository.findById(responseId)).thenReturn(Optional.empty());

        // Act
        Response retrievedResponse = responseService.getResponseById(responseId);

        // Assert
        assertNull(retrievedResponse);
        verify(responseRepository, times(1)).findById(responseId);
    }

    @Test
    void updateResponse_existingResponse_shouldReturnUpdatedResponse() {
        // Arrange
        Response response = new Response();
        response.setResponseId(1);
        response.setResponseDetails("Details 1");
        when(responseRepository.existsById(anyInt())).thenReturn(true);
        when(responseRepository.save(any(Response.class))).thenReturn(response);

        // Act
        Response updatedResponse = responseService.updateResponse(response);

        // Assert
        assertNotNull(updatedResponse);
        assertEquals(response, updatedResponse);
        verify(responseRepository, times(1)).existsById(response.getResponseId());
        verify(responseRepository, times(1)).save(response);
    }

    @Test
    void updateResponse_nonExistingResponse_shouldReturnNull() {
        // Arrange
        Response response = new Response();
        response.setResponseId(2);
        response.setResponseDetails("Details 2");
        when(responseRepository.existsById(anyInt())).thenReturn(false);

        // Act
        Response updatedResponse = responseService.updateResponse(response);

        // Assert
        assertNull(updatedResponse);
        verify(responseRepository, times(1)).existsById(response.getResponseId());
        verify(responseRepository, never()).save(any(Response.class));
    }

    @Test
    void deleteResponseById_existingResponseId_shouldReturnSuccessMessage() {
        // Arrange
        Integer responseId = 1;
        when(responseRepository.findById(responseId)).thenReturn(Optional.of(new Response()));

        // Act
        String result = responseService.deleteResponseById(responseId);

        // Assert
        assertEquals("Deleted the response.", result);
        verify(responseRepository, times(1)).findById(responseId);
        verify(responseRepository, times(1)).deleteById(responseId);
    }

    @Test
    void deleteResponseById_nonExistingResponseId_shouldReturnNotFoundMessage() {
        // Arrange
        Integer responseId = 2;
        when(responseRepository.findById(responseId)).thenReturn(Optional.empty());

        // Act
        String result = responseService.deleteResponseById(responseId);

        // Assert
        assertEquals("Could not find response by Id.", result);
        verify(responseRepository, times(1)).findById(responseId);
        verify(responseRepository, never()).deleteById(anyInt());
    }
}
