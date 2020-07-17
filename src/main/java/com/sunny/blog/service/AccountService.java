package com.sunny.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.blog.dto.SendRequestDto;
import com.sunny.blog.dto.WithDrawRequestDto;
import com.sunny.blog.model.Account;
import com.sunny.blog.repository.AccountRepository;

// 데이터베이스 객체가 필요
@Service
public class AccountService { 
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional // 하나라도 안되면 rollback 되고, 둘다 완료되면 commit됨
	public void 송금(SendRequestDto dto) { //누가 누구에게 얼마를
		
		// 보내는사람 업데이트 - 시켜줌, a1이 홍길동
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		
		// 보내는사람 값을 변경
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
		
		// 받는사람 업데이트 + 시켜줌, a2는 장보고
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		
		//받는사람 값을 변경
		장보고.setMoney(장보고.getMoney() + dto.getMoney());
		accountRepository.update(장보고);
	} // 트랜잭션은 이 함수가 종료되면 실행됨 (트랜잭션 단위)
	
	
	@Transactional
	public void 인출(WithDrawRequestDto dto) { // 누가 얼마를
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		//persistence : DB의 있는 값을 오브젝트로 만드는 것, DB 내용과 동기화
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
	} // 하나의 트랜잭션 단위 
	
	
	@Transactional(readOnly = true) // read만 하는 트랜잭션 // 고립성 때문에
	public List<Account> 계좌정보보기(){
		return accountRepository.findAll();
	}
}
