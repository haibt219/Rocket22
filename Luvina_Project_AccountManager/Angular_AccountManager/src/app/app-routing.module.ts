import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AccountsComponent } from './accounts/accounts.component';
import { AccountRegisterFormComponent } from './account-resgister-form/account-register-form.component';
import { AccountUpdateFormComponent } from './account-update-form/account-update-form.component';
import { DepartmentsComponent } from './departments/departments.component';
import { PositionsComponent } from './positions/positions.component';

const routes: Routes = [
  // path Home
  { path: '', component: HomeComponent },
  // path Account
  { path: 'accounts', component: AccountsComponent },
  { path: 'account-register-form', component: AccountRegisterFormComponent },
  {
    path: 'account-register-form/:id',
    component: AccountRegisterFormComponent,
  },
  { path: 'account-update-form', component: AccountUpdateFormComponent },
  { path: 'account-update-form/:id', component: AccountUpdateFormComponent },
  // path Department
  { path: 'departments', component: DepartmentsComponent },

  // path Position
  { path: 'positions', component: PositionsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
