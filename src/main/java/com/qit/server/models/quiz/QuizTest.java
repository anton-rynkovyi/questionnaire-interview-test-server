package com.qit.server.models.quiz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tests")
public class QuizTest extends Quiz {
}
