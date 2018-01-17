package com.qit.server.service.quizzes.interview;

import com.qit.server.models.Interview;

import java.util.List;

public interface InterviewService {

    Interview findInterview(Long quizId);
    Interview saveInterview(Interview interview);
    void removeInterview(Long quizId);
    List<Interview> findAllInterviews();

}