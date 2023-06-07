import { Component } from '@angular/core';
import { Account } from '../models/Account';
import { AccountsService } from '../accounts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css'],
})
export class AccountsComponent {
  public listAccounts: Account[] = [];
  constructor(
    private accountService: AccountsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.accountService.getAccounts().subscribe((data) => {
      console.log(data);
      this.listAccounts = data;
    });
  }

  public getListAcounts() {
    this.accountService.getAccounts().subscribe((data) => {
      console.log(data);
      this.listAccounts = data;
    });
  }

  /**
   * Đường dẫn đến page addAccount
   */
  public addAccount() {
    this.router.navigate(['account-register-form']);
  }

  /**
   * deleteAccount
   */
  public deleteAccount(id: any) {
    console.log('account id: ' + id);
    this.accountService.deleteAccount(Number(id)).subscribe((data) => {
      alert('You want delete: ' + data.name);
    });
    this.getListAcounts();
  }

  /**
   * editAccount
   */
  public editAccount(id: any) {
    this.router.navigate(['account-update-form', id]);
  }
}
