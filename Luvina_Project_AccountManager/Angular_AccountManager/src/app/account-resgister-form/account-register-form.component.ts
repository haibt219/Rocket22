import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../models/Account';
import { AccountsService } from '../accounts.service';

@Component({
  selector: 'app-account-form',
  templateUrl: './account-register-form.component.html',
  styleUrls: ['./account-register-form.component.css'],
})
export class AccountRegisterFormComponent {
  id: number = 0;
  public accountRegisterForm: any = new FormGroup({
    id: new FormControl(''),
    email: new FormControl(''),
    userName: new FormControl(''),
    fullName: new FormControl(''),
    department: new FormControl(''),
    position: new FormControl(''),
    createDate: new FormControl(''),
  });

  constructor(
    private accountService: AccountsService,
    private router: Router,
    private myroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const idParam = this.myroute.snapshot.paramMap.get('id');
    this.id = idParam ? +idParam : 0;
    console.log('id = ', this.id);
    if (this.id > 0) {
      this.loadData(this.id);
    }
  }

  public onSubmit() {
    var account: Account = {
      id: this.accountRegisterForm.get('id')?.value,
      email: this.accountRegisterForm.get('email')?.value,
      userName: this.accountRegisterForm.get('userName')?.value,
      fullName: this.accountRegisterForm.get('fullName')?.value,
      department: this.accountRegisterForm.get('departmentId')?.value,
      position: this.accountRegisterForm.get('positionId')?.value,
      createDate: this.accountRegisterForm.get('createDate')?.value,
    };

    this.accountService.addAccount(account as Account).subscribe((data) => {
      console.log('Add Account' + data);
      this.router.navigate(['accounts']);
    });
  }

  private loadData(id: number) {
    console.log('load data', id);
    this.accountService.getAccountById(id).subscribe((data) => {
      console.log('get account: ', data);

      for (const control in this.accountRegisterForm.controls) {
        if (control) {
          this.accountRegisterForm.controls[control].setValue(data[control]);
        }
      }
    });
  }
}
