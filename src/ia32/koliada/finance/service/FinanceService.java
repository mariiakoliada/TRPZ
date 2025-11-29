package ia32.koliada.finance.service;

import ia32.koliada.finance.entity.Account;
import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.repository.AccountRepository;
import ia32.koliada.finance.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.List;

public class FinanceService {
    private AccountRepository accountRepo;
    private TransactionRepository transactionRepo;

    public FinanceService() {
        this.accountRepo = new AccountRepository();
        this.transactionRepo = new TransactionRepository();
    }

    public void addTransaction(Long accountId, Long categoryId, BigDecimal amount, String desc) {
        Account account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Рахунок не знайдено!"));

        Transaction tx = new Transaction(null, accountId, categoryId, amount, desc);
        transactionRepo.save(tx);

        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);
        accountRepo.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }
}