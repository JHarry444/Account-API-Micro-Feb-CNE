package com.qa.account.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.service.PrizeGenService;

@RestController
public class PrizeGenController {

	private PrizeGenService service;

	public PrizeGenController(PrizeGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/genPrize/{accountNumber}")
	public String getPrize(@PathVariable String accountNumber) {
		return "" + this.service.genPrize(accountNumber);
	}
}
