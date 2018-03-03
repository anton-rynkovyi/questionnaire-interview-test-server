package com.qit.server.dao;

import com.qit.server.models.quiz.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewDao extends JpaRepository<Interview, Long> {
}
