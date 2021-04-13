package com.qa.account.service;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenService {

	public double genPrize(String accountNum) {
		double prize = 0;
		accountNum = accountNum.toLowerCase();
		final int numLength  = accountNum.length();
		if (accountNum.startsWith("b")) {
			if (numLength == 7) {
				prize =  50;
			} else if (numLength == 9) {
				prize =  500;
			} else if (numLength == 10) {
				prize =  5000;
			}
		} else if (accountNum.startsWith("c")) {
			if (numLength == 7) {
				prize =  100;
			} else if (numLength == 9) {
				prize =  750;
			} else if (numLength == 10) {
				prize =  10000;
			}
		}
		return prize;
	}
}
