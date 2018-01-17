package com.qit.server.rest.controllers.quizzes.interview;

import com.qit.server.models.Interview;
import com.qit.server.service.quizzes.interview.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
public class CrudInterviewController {

    @Autowired
    private InterviewService interviewService;

    @RequestMapping(path = "/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<Interview> getInterview(@PathVariable("quizId") Long quizId) {
        Interview interview = interviewService.findInterview(quizId);
        return interview != null ? ResponseEntity.ok(interview) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(interview);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Interview> getAllInterviews() {
        return interviewService.findAllInterviews();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Interview saveInterview(@RequestBody Interview interview) {
        return interviewService.saveInterview(interview);
    }

    @RequestMapping(path = "/{quizId}", method = RequestMethod.DELETE)
    public void removeInterview(@PathVariable("quizId") Long quizId) {
        interviewService.removeInterview(quizId);
    }
}
