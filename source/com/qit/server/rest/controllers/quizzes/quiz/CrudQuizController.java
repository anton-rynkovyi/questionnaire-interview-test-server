package com.qit.server.rest.controllers.quizzes.quiz;

import com.qit.server.models.Quiz;
import com.qit.server.rest.dto.quizzes.quiz.QuizDTO;
import com.qit.server.service.quizzes.quiz.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class CrudQuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(path = "/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<QuizDTO> getQuiz(@PathVariable("quizId") Long quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        QuizDTO quizDTO = modelMapper.map(quiz, QuizDTO.class);
        return quiz != null ? ResponseEntity.ok(quizDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(quizDTO);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<QuizDTO> getAllQuizzes() {
        List<QuizDTO> quizDTOs = new ArrayList<>();
        List<Quiz> quizzes = quizService.findAllQuizzes();
        for (Quiz quiz : quizzes){
            quizDTOs.add(modelMapper.map(quiz, QuizDTO.class));
        }
        return quizDTOs;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public QuizDTO saveQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);
        quizService.saveQuiz(quiz);
        return quizDTO;
    }

    @RequestMapping(path = "/{quizId}", method = RequestMethod.DELETE)
    public void removeQuiz(@PathVariable("quizId") Long quizId) {
        quizService.removeQuiz(quizId);
    }
}
