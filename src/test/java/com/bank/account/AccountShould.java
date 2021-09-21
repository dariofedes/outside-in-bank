package com.bank.account;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class AccountShould {

	@Test
	void return_a_statement_report() {
		// given
		ITransactionRepository mockRepository = mock(ITransactionRepository.class);
		Account account = new Account(mockRepository);
		Date dateMock = mock(Date.class);
		when(dateMock.getDateString()).thenReturn("10-01-2012", "13-01-2012", "14-01-2012");
		account.deposit(1000);
		account.deposit(2000);
		account.withdraw(500);
		Console mockConsole = mock(Console.class);

		// when
		account.printStatement();

		// assert
		verify(mockConsole).print("Date       || Amount || Balance\n14/01/2012 || -500   || 2500\n13/01/2012 || 2000   || 3000\n10/01/2012 || 1000   || 1000");
	}

	@Test
	void record_deposit() {
		ITransactionRepository mockTransactionRepository = mock(ITransactionRepository.class);
		Account account = new Account(mockTransactionRepository);
		Deposit deposit = new Deposit(1000);

		//when
		account.deposit(1000);

		verify(mockTransactionRepository).saveTransaction(deposit);
	}
}
