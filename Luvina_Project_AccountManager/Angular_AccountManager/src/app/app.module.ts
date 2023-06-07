import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountsComponent } from './accounts/accounts.component';
import { HomeComponent } from './home/home.component';
import { AccountRegisterFormComponent } from './account-resgister-form/account-register-form.component';
import { AccountUpdateFormComponent } from './account-update-form/account-update-form.component';
import { DepartmentsComponent } from './departments/departments.component';
import { PositionsComponent } from './positions/positions.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountsComponent,
    HomeComponent,
    AccountRegisterFormComponent,
    AccountUpdateFormComponent,
    DepartmentsComponent,
    PositionsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
