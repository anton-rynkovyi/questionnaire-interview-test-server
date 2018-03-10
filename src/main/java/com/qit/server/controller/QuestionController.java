package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.dto.QuestionDto;
import com.qit.server.dto.VariantDto;
import com.qit.server.models.answer.Variant;
import com.qit.server.models.question.Question;
import com.qit.server.models.question.QuestionType;
import com.qit.server.models.quiz.Quiz;
import com.qit.server.service.question.QuestionService;
import com.qit.server.service.quiz.QuizService;
import com.qit.server.service.variant.VariantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService<Quiz> quizService;

	@Autowired
	private VariantService variantService;


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

	@RequestMapping(params = "quizId", method = RequestMethod.GET)
	public List<QuestionDto> findQuestionsByQuestionnaireId(@RequestParam("quizId") Long quizId) {
		List<Question> questions = questionService.getQuestionsByQuizId(quizId);
		List<QuestionDto> questionDtoList = new ArrayList<>();
		for	(Question question : questions) {
			QuestionDto questionDto = new QuestionDto();
			questionDto.setId(question.getId());
			questionDto.setQuizId(quizId);
			questionDto.setIsNecessary(question.getIsNecessary());
			questionDto.setQuestionType(question.getQuestionType());
			questionDto.setText(question.getText());

			List<Variant> variants = variantService.getVariantsByQuestionId(question.getId());
			Set<VariantDto> variantDtoList = new LinkedHashSet<>();

			for (Variant variant : variants) {
				VariantDto variantDto = new VariantDto();
				variantDto.setId(variant.getId());
				variantDto.setQuestionId(questionDto.getId());
				variantDto.setText(variant.getText());

				variantDtoList.add(variantDto);
			}
			questionDto.setVariants(variantDtoList);

			questionDtoList.add(questionDto);
		}
		return questionDtoList;
	}
}
