package com.qit.server.controller;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.quiz.Result;
import com.qit.server.service.result.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/result")
public class ResultController {

	@Autowired
	private ResultService resultService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Result> getAllResults() {
		return resultService.getAllResults();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result getResult(@PathVariable("id") Long id) {
		return resultService.getResult(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<QitResponse> saveResult(@RequestBody Result result) {
		return new ResponseEntity<>(resultService.save(result), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<QitResponse> deleteResult(@PathVariable("id") Long id) {
		return new ResponseEntity<>(resultService.deleteById(id), HttpStatus.OK);
	}

}
