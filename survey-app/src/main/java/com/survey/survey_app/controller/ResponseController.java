package com.survey.survey_app.controller;

import com.survey.survey_app.entity.Response;
import com.survey.survey_app.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    // SUBMIT RESPONSE
    @PostMapping
    public Response submitResponse(@RequestBody Response response) {
        return responseService.saveResponse(response);
    }

    // GET ALL RESPONSES
    @GetMapping
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }
}