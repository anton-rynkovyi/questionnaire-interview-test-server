package com.qit.server.dao;

import com.qit.server.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arizel on 18.02.2018.
 */
public interface QuestionDao extends JpaRepository<Question, Long> {
}
