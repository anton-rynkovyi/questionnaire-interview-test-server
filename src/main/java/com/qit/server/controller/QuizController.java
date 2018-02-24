package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.answer.Answer;
import com.qit.server.model.quiz.Quiz;
import com.qit.server.service.answer.AnswerService;
import com.qit.server.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(name = "/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Quiz> getQuizzes() {
		return quizService.getAllQuizzes();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Quiz getQuizById(@PathVariable("id") Long id) {
		return quizService.getQuiz(id);
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
