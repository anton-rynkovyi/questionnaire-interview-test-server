package com.qit.server.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionnaireDto {

    private Long id;
    private String summary;
    private String description;
    private String password;
    private Long userId;
    private Date startDate;
    private Date endDate;
    private boolean anonymity;
    private Integer answerLimit;

}
