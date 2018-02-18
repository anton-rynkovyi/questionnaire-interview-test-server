package com.qit.server.dao;

import com.qit.server.model.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDao extends JpaRepository<Answer, Long> {
}
