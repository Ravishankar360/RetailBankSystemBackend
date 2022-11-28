package com.RetialBank.TransactionService.Service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.RetialBank.TransactionService.Entity.Account;
import com.RetialBank.TransactionService.Entity.Transaction;
import com.RetialBank.TransactionService.Repository.TransactionRepository;

import org.springframework.http.ResponseEntity;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transRepo;

	//@Autowired
	//private LoadBalancerClient loadBalancer;

	@Override
	public Long deposit(Account account) {
//		ServiceInstance serviceInstance = loadBalancer.choose("RETAIL_BANKING");
//		System.out.println(serviceInstance.getUri());
//		String baseUrl = serviceInstance.getUri().toString();
//		String url = baseUrl + "/api/account/updateBalance?accountId=" + account.getAccountId() + "&amount="
//				+ account.getBalance() + "&type=credit";
//		RestTemplate restTemplate = new RestTemplate();
//		System.out.println("url-" + url);
//		long ab = 0;
//		try {
//			ResponseEntity<Transaction> response = restTemplate.getForEntity(url, Transaction.class);
//			Transaction tt = response.getBody();
//			if (tt.getAbalance() < account.getBalance()) {
//				return ab;
//			} else {
//				// tt.setDate(new Date().getTime());
//				tt.setDate(new Date());
//				tt.setType("credit");
//				ab = transRepo.save(tt).getTransId();
//				return ab;
//			}
//		} catch (Exception t) {
//			t.printStackTrace();
//		} finally {
//			return ab;
//		}
		return null;
	}

	@Override
	public Long withdraw(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Transaction> getall() {
		return (ArrayList<Transaction>) transRepo.findAll();
	}

}
