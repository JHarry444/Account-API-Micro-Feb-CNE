package com.qa.account.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.service.AccountNumGenService;

@RestController
public class NumGenController {

	private AccountNumGenService service;

	public NumGenController(AccountNumGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getNum")
	public String generateNumber() {
		return this.service.genNumber();
	}
}
