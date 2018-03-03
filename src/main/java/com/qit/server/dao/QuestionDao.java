package com.qit.server.dao;

import com.qit.server.models.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question, Long> {
}
