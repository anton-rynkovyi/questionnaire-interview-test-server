package com.qit.server.dao;

import com.qit.server.model.quiz.Result;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arizel on 18.02.2018.
 */
public interface ResultDao extends JpaRepository<Result, Long> {
}
