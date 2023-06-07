package net.luvina.backend.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.backend.datalayer.IAccountRepository;
import net.luvina.backend.datalayer.IDepartmentRepository;
import net.luvina.backend.datalayer.IPositionRepository;
import net.luvina.entity.Account;
import net.luvina.entity.Department;
import net.luvina.entity.Position;
import net.luvina.form.AccountFormForCreating;
import net.luvina.form.AccountFormForUpdate;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IPositionRepository positionRepository;

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(int idInput) {
		return accountRepository.findById(idInput).get();
	}

	@Override
	public Account getAccountByUserName(String userNameAcc) {
		return accountRepository.findByUserName(userNameAcc);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void createAccount(AccountFormForCreating form) {
		Account account = new Account();
		account.setEmail(form.getEmail());
		account.setUserName(form.getUserName());
		account.setFullName(form.getFullName());

		Department department = departmentRepository.getById(form.getDepartmentId());
		account.setDepartment(department);

		Position position = positionRepository.getById(form.getPositionId());
		account.setPosition(position);
		accountRepository.save(account);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateAccountById(int id, AccountFormForUpdate form) {
		Account account = accountRepository.getById(id);
		account.setFullName(form.getFullName());

		Department department = departmentRepository.getById(form.getDepartmentId());
		account.setDepartment(department);

		Position position = positionRepository.getById(form.getPositionId());
		account.setPosition(position);

		accountRepository.save(account);
	}

	@Override
	public void deleteAccountById(int id) {
		accountRepository.deleteById(id);

	}

}
