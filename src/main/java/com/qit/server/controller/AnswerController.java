package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;
import com.qit.server.service.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Answer> getAnswers() {
		return answerService.getAllAnswers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Answer getAnswerById(@PathVariable("id") Long id) {
		return answerService.getAnswer(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> createAnswer(@RequestBody Answer answer, HttpServletRequest request) {
		return new ResponseEntity<>(answerService.save(answer), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteAnswer(@PathVariable("id") Long id, HttpServletRequest request) {
		return new ResponseEntity<QitResponse>(answerService.deleteById(id), HttpStatus.OK);
	}

}
