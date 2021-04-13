package com.qa.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;
import com.qa.account.util.exceptions.AccountNotFoundException;

@Service
public class AccountService {

	private AccountRepo repo;
	private RestTemplate rest;

	@Autowired
	public AccountService(AccountRepo repo, RestTemplate rest) {
		super();
		this.repo = repo;
		this.rest = rest;
	}

	public List<Account> getAccounts() {
		return repo.findAll();
	}

	public Account getAccount(Long id) {
		return repo.findById(id).orElseThrow(() -> new AccountNotFoundException(id.toString()));

	}

	public Account addAccount(Account account) { // Account fname + lname
		String accountNumber = this.rest.getForObject("http://NUM-GEN/getNum", String.class);
		account.setAccountNumber(accountNumber); // string accNo
		String prize = this.rest.getForObject("http://PRIZE-GEN/genPrize/" + accountNumber, String.class);
		account.setPrize(Double.parseDouble(prize)); // double prize
		return this.repo.save(account); // Account toSave Account saved
	}

	public boolean deleteAccount(Long id) {
		if (accountExists(id)) {
			repo.deleteById(id);
		}
		return repo.existsById(id);
	}

	private boolean accountExists(Long id) {
		return repo.findById(id).isPresent();
	}

	public Account updateAccount(Account account, Long id) {
		if (accountExists(id)) {
			Account toUpdate = this.repo.findById(id).get();
			toUpdate.setFirstName(account.getFirstName());
			toUpdate.setLastName(account.getLastName());
			return repo.save(account);
		}
		return null;
	}

}
