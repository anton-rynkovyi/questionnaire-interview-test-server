package com.qit.server.rest.controllers;

import com.qit.server.models.Interview;
import com.qit.server.rest.dto.InterviewDTO;
import com.qit.server.service.quizzes.interview.InterviewService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/interviews")
public class InterviewController {

    final static Logger LOGGER = Logger.getLogger(InterviewController.class);

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<InterviewDTO> getInterview(@PathVariable("quizId") Long quizId) {
        LOGGER.info("CrudInterviewController.getInterview execute");

        Interview interview = interviewService.findInterview(quizId);
        InterviewDTO interviewDTO = modelMapper.map(interview, InterviewDTO.class);
        return interview != null ? ResponseEntity.ok(interviewDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(interviewDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<InterviewDTO> getAllInterviews() {
        LOGGER.info("CrudInterviewController.getAllInterviews execute");

        List<InterviewDTO> interviewDTOs = new ArrayList<InterviewDTO>();
        List<Interview> interviews = interviewService.findAllInterviews();
        for (Interview interview : interviews){
            interviewDTOs.add(modelMapper.map(interview, InterviewDTO.class));
        }
        return interviewDTOs;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public InterviewDTO saveInterview(@RequestBody InterviewDTO interviewDTO) {
        LOGGER.info("CrudInterviewController.saveInterview execute");

        Interview interview = modelMapper.map(interviewDTO, Interview.class);
        interviewService.saveInterview(interview);
        return interviewDTO;
    }

    @RequestMapping(path = "/{quizId}", method = RequestMethod.DELETE)
    public void removeInterview(@PathVariable("quizId") Long quizId) {
        LOGGER.info("CrudInterviewController.removeInterview execute");
        interviewService.removeInterview(quizId);
    }
}
