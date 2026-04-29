package com.survey.survey_app.service;

import com.survey.survey_app.entity.Response;
import com.survey.survey_app.repository.ResponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    // SAVE RESPONSE
    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    // GET ALL RESPONSES
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }
}