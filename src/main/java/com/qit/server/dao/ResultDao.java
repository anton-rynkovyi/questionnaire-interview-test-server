package com.qit.server.dao;

import com.qit.server.models.quiz.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultDao extends JpaRepository<Result, Long> {
}
