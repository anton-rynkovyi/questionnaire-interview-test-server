package com.qit.server.dao;

import com.qit.server.models.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Long> {
}
