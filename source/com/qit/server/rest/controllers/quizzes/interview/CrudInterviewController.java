package com.qit.server.rest.controllers.quizzes.interview;

import com.qit.server.models.Interview;
import com.qit.server.rest.dto.quizzes.interview.InterviewDTO;
import com.qit.server.service.quizzes.interview.InterviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interviews")
public class CrudInterviewController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<InterviewDTO> getInterview(@PathVariable("quizId") Long quizId) {
        Interview interview = interviewService.findInterview(quizId);
        InterviewDTO interviewDTO = modelMapper.map(interview, InterviewDTO.class);
        return interview != null ? ResponseEntity.ok(interviewDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(interviewDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<InterviewDTO> getAllInterviews() {
        List<InterviewDTO> interviewDTOs = new ArrayList<>();
        List<Interview> interviews = interviewService.findAllInterviews();
        for (Interview interview : interviews){
            interviewDTOs.add(modelMapper.map(interview, InterviewDTO.class));
        }
        return interviewDTOs;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public InterviewDTO saveInterview(@RequestBody InterviewDTO interviewDTO) {
        Interview interview = modelMapper.map(interviewDTO, Interview.class);
        interviewService.saveInterview(interview);
        return interviewDTO;
    }

    @RequestMapping(path = "/{quizId}", method = RequestMethod.DELETE)
    public void removeInterview(@PathVariable("quizId") Long quizId) {
        interviewService.removeInterview(quizId);
    }
}
