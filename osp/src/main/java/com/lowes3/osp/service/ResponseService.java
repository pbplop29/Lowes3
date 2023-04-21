package com.lowes3.osp.service;
import org.springframework.stereotype.Service;
import com.lowes3.osp.entity.Response;

@Service
public interface ResponseService {
    public Response saveResponse(Response response);
    public Response getResponseById(Integer userId);
    public Response updateResponse(Response response);
    public String deleteResponseById(Integer userId);
}

