package com.qit.server.repositories;

import com.qit.server.models.AnswerVariant;
import com.qit.server.models.QitQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerVariantRepository extends JpaRepository<AnswerVariant, Long> {

    List<AnswerVariant> findAnswerVariantsByQitQuestion(QitQuestion qitQuestionquestion);
    List<AnswerVariant> findAnswerVariantsByQitQuestionQuestionId(Long questionId);

    @Modifying
    @Query(value = "DELETE FROM AnswerVariant WHERE answerVariantId = ?1")
    void removeById(Long id);
}
