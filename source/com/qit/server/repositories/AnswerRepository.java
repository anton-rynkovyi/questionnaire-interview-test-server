package com.qit.server.repositories;

import com.qit.server.models.QitAnswer;
import com.qit.server.models.QitQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<QitAnswer, Long> {

    List<QitAnswer> findQitAnswersByQitQuestion(QitQuestion qitQuestion);

    List<QitAnswer> findQitAnswersByQitQuestionQuestionId(Long questionId);
}
