package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.question.Question;
import com.qit.server.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Question getQuestion(@PathVariable("id") Long id) {
		return questionService.getQuestion(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveQuestion(@RequestBody Question question) {
		return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteQuestion(@PathVariable("id") Long id) {
		return new ResponseEntity<>(questionService.deleteQuestionById(id), HttpStatus.OK);
	}

}
