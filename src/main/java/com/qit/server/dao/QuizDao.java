package com.qit.server.dao;

import com.qit.server.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arizel on 18.02.2018.
 */
public interface QuizDao extends JpaRepository<Quiz, Long> {
}
