package com.qit.server.repositories;

import com.qit.server.models.QitQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QitQuestion, Long>{
}
