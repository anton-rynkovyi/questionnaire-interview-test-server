package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Interview;
import com.qit.server.model.quiz.Questionnaire;
import com.qit.server.model.quiz.Quiz;
import com.qit.server.service.quiz.QuizService;
import com.qit.server.service.quiz.impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/quizzes")
public class QuizController {

	@Autowired
	private QuizService<Questionnaire> questionnaireService;

	@Autowired
	private QuizService<Interview> interviewService;

	@Autowired
	private QuizServiceImpl quizService;


	@RequestMapping(value = "/questionnaires", method = RequestMethod.GET)
	public List<Questionnaire> getQuestionnaires() {
		return questionnaireService.getAll();
	}

	@RequestMapping(value = "/questionnaires/{id}", method = RequestMethod.GET)
	public Questionnaire getQuestionnaireById(@PathVariable("id") Long id) {
		return questionnaireService.getOne(id);
	}

	@RequestMapping(value = "/questionnaires", method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveQuestionnaire(@RequestBody Questionnaire questionnaire,
														 HttpServletRequest request) {
		return new ResponseEntity<>(questionnaireService.save(questionnaire), HttpStatus.OK);
	}

	@RequestMapping(value = "/questionnaires/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteQuestionnaire(@PathVariable("id") Long id, HttpServletRequest request) {
		return new ResponseEntity<>(questionnaireService.deleteById(id), HttpStatus.OK);
	}


	@RequestMapping(value = "/interviews", method = RequestMethod.GET)
	public List<Interview> getInterviews() {
		return interviewService.getAll();
	}

	@RequestMapping(value = "/interviews/{id}", method = RequestMethod.GET)
	public Interview getInterviewById(@PathVariable("id") Long id) {
		return interviewService.getOne(id);
	}

	@RequestMapping(value = "/interviews", method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveInterview(@RequestBody Interview interview,
														 HttpServletRequest request) {
		return new ResponseEntity<>(interviewService.save(interview), HttpStatus.OK);
	}

	@RequestMapping(value = "/interviews/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteInterview(@PathVariable("id") Long id, HttpServletRequest request) {
		return new ResponseEntity<>(interviewService.deleteById(id), HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public List<Quiz> getQuizzes() {
		return quizService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Quiz getQuizById(@PathVariable("id") Long id) {
		return quizService.getOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveQuiz(@RequestBody Quiz quiz, HttpServletRequest request) {
		return new ResponseEntity<>(quizService.save(quiz), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteQuiz(@PathVariable("id") Long id, HttpServletRequest request) {
		return new ResponseEntity<>(quizService.deleteById(id), HttpStatus.OK);
	}
}
