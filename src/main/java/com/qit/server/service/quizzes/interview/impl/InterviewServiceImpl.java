package com.qit.server.service.quizzes.interview.impl;

import com.qit.server.models.Interview;
import com.qit.server.repositories.InterviewRepository;
import com.qit.server.service.quizzes.interview.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    private InterviewRepository interviewRepository;

    /*==============CRUD==============*/

    @Override
    public Interview findInterview(Long quizId) {
        return interviewRepository.findOne(quizId);
    }

    @Override
    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public void removeInterview(Long quizId) {
        interviewRepository.delete(quizId);
    }

    @Override
    public List<Interview> findAllInterviews() {
        return interviewRepository.findAll();
    }

    /*==================Autowired==================*/

    @Autowired
    public void setInterviewRepository(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }
}
