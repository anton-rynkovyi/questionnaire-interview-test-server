package com.qit.server.repositories;

import com.qit.server.models.QitAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<QitAnswer, Long> {
}
