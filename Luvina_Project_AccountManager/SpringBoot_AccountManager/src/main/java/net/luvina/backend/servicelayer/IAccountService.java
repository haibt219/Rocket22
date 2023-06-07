package net.luvina.backend.servicelayer;

import java.util.List;

import net.luvina.entity.Account;
import net.luvina.form.AccountFormForCreating;
import net.luvina.form.AccountFormForUpdate;

public interface IAccountService {
	public List<Account> getAllAccount();

	public Account getAccountById(int idInput);

	public Account getAccountByUserName(String userNameAcc);

	public void createAccount(AccountFormForCreating form);

	public void updateAccountById(int id, AccountFormForUpdate form);

	public void deleteAccountById(int id);
}
