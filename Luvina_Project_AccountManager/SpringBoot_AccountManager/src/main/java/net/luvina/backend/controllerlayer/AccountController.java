package net.luvina.backend.controllerlayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.luvina.DTO.AccountDTO;
import net.luvina.backend.servicelayer.IAccountService;
import net.luvina.entity.Account;
import net.luvina.form.AccountFormForCreating;
import net.luvina.form.AccountFormForUpdate;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService service;

	// Get All Account
	@GetMapping()
	public ResponseEntity<?> getAllAccount() {
		List<Account> listAccounts = service.getAllAccount();

		List<AccountDTO> listAccountDTOs = new ArrayList<>();

		for (Account account : listAccounts) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(account.getId());
			accountDTO.setEmail(account.getEmail());
			accountDTO.setUserName(account.getUserName());
			accountDTO.setFullName(account.getFullName());
			accountDTO.setDepartment(account.getDepartment().getName().toString());
			accountDTO.setPosition(account.getPosition().getName().toString());
			accountDTO.setCreateDate(account.getCreateDate());
			listAccountDTOs.add(accountDTO);
		}
		return new ResponseEntity<>(listAccountDTOs, HttpStatus.OK);
	}

	// Get Account By Id
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") int idInput) {
		Account account = service.getAccountById(idInput);

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setEmail(account.getEmail());
		accountDTO.setUserName(account.getUserName());
		accountDTO.setFullName(account.getFullName());
		accountDTO.setDepartment(account.getDepartment().getName().toString());
		accountDTO.setPosition(account.getPosition().getName().toString());
		accountDTO.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accountDTO, HttpStatus.OK);

	}

	// Get Account By Name
	@GetMapping("/username/{username}")
	public ResponseEntity<?> getAccountByName(@PathVariable(name = "username") String userNameAcc) {
		Account account = service.getAccountByUserName(userNameAcc);

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setEmail(account.getEmail());
		accountDTO.setUserName(account.getUserName());
		accountDTO.setFullName(account.getFullName());
		accountDTO.setDepartment(account.getDepartment().getName().toString());
		accountDTO.setPosition(account.getPosition().getName().toString());
		accountDTO.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accountDTO, HttpStatus.OK);
	}

	// Create Account
	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		service.createAccount(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	// Update Account
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccountById(@PathVariable(name = "id") int id,
			@RequestBody AccountFormForUpdate form) {
		service.updateAccountById(id, form);
		return new ResponseEntity<String>("Upddate successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccountById(@PathVariable(name = "id") int id) {
		service.deleteAccountById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
