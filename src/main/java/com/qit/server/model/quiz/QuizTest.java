package com.qit.server.model.quiz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tests")
public class QuizTest extends Quiz {
}
