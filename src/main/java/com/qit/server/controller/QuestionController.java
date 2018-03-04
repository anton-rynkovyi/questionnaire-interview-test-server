package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.dto.QuestionDto;
import com.qit.server.models.answer.Variant;
import com.qit.server.models.question.Question;
import com.qit.server.models.question.QuestionType;
import com.qit.server.models.quiz.Quiz;
import com.qit.server.service.question.QuestionService;
import com.qit.server.service.quiz.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService<Quiz> quizService;


	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Question getQuestion(@PathVariable("id") Long id) {
		return questionService.getQuestion(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveQuestion(@RequestBody QuestionDto questionDto) {
		Question question = new Question();
		question.setId(questionDto.getId());
		question.setText(questionDto.getText());
		question.setIsNecessary(questionDto.getIsNecessary());
		if (QuestionType.CHECKBOX.toString().equals(questionDto.getQuestionType().toString())) {
			question.setQuestionType(QuestionType.CHECKBOX);
		} else if (QuestionType.RADIO.toString().equals(questionDto.getQuestionType().toString())) {
			question.setQuestionType(QuestionType.RADIO);
		}

		question.setQuiz(quizService.getOne(questionDto.getQuizId()));

		return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteQuestion(@PathVariable("id") Long id) {
		return new ResponseEntity<>(questionService.deleteQuestionById(id), HttpStatus.OK);
	}
}
