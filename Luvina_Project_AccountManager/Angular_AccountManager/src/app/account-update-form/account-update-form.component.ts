import { Component } from '@angular/core';
import { Account } from '../models/Account';
import { FormControl, FormGroup } from '@angular/forms';
import { AccountsService } from '../accounts.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-account-update-form',
  templateUrl: './account-update-form.component.html',
  styleUrls: ['./account-update-form.component.css'],
})
export class AccountUpdateFormComponent {
  id: number = 0;
  public accountUpdateForm: any = new FormGroup({
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
      id: this.accountUpdateForm.get('id')?.value,
      email: this.accountUpdateForm.get('email')?.value,
      userName: this.accountUpdateForm.get('userName')?.value,
      fullName: this.accountUpdateForm.get('fullName')?.value,
      department: this.accountUpdateForm.get('departmentId')?.value,
      position: this.accountUpdateForm.get('positionId')?.value,
      createDate: this.accountUpdateForm.get('createDate')?.value,
    };

    this.accountService
      .updateAccount(this.id, account as Account)
      .subscribe((data) => {
        console.log('Update Account' + data);
        this.router.navigate(['accounts']);
      });
  }

  private loadData(id: number) {
    console.log('load data', id);
    this.accountService.getAccountById(id).subscribe((data) => {
      console.log('get account: ', data);

      for (const control in this.accountUpdateForm.controls) {
        if (control) {
          this.accountUpdateForm.controls[control].setValue(data[control]);
        }
      }
    });
  }
}
