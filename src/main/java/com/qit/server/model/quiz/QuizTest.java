package com.qit.server.model.quiz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Tests")
public class QuizTest extends Quiz {
}
