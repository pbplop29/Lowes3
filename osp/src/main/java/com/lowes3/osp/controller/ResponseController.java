package com.lowes3.osp.controller;
import org.springframework.stereotype.Controller;



import com.lowes3.osp.entity.Response;
import com.lowes3.osp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    //Create or save or add
    //http://localhost:8080/saveResponse
    @PostMapping("/saveResponse")
    public String saveResponse (@RequestBody List<Response> responses ) {
        for(Response response:responses){
            responseService.saveResponse(response);
        }
        return "Successfully Responded";
    }

    //http://localhost:8080/getResponse /1
    @GetMapping("/getResponse/{responseId}")
    public Response getResponseById(@PathVariable("responseId") Integer responseId) {
        return responseService.getResponseById(responseId);
    }

    //http://localhost:8080/updateResponse
    @PutMapping("/updateResponse")
    public Response  updateResponse (@RequestBody Response response ){
        return responseService.updateResponse(response);
    }

    //http://localhost:8080/deleteResponse/1
    @DeleteMapping("/deleteResponse/{responseId}")
    public String deleteResponseByID(@PathVariable("responseId") Integer responseId){
        String checkIfDeleted = responseService.deleteResponseById(responseId);
        return checkIfDeleted;
    }
}
