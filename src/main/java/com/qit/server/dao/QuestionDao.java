package com.qit.server.dao;

import com.qit.server.models.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Long> {

    List<Question> findQuestionsByQuizId(Long quizId);
}
