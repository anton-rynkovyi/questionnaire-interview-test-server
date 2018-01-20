package com.qit.server.repositories;

import com.qit.server.models.QitQuestion;
import com.qit.server.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QitQuestion, Long> {

    List<QitQuestion> findQitQuestionsByQuiz(Quiz quiz);
    List<QitQuestion> findQitQuestionsByQuizQuizId(Long quizId);

    @Modifying
    @Query(value = "DELETE FROM QitQuestion WHERE questionId = ?1")
    void removeById(Long id);
}
