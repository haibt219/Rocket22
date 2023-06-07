package net.luvina.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import net.luvina.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

	public Account findByUserName(String name);
}
