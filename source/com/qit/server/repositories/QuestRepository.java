package com.qit.server.repositories;

import com.qit.server.models.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Questionnaire, Long> {

}
