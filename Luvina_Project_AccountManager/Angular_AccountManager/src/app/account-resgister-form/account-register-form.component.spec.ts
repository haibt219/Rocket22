import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountRegisterFormComponent } from './account-register-form.component';

describe('SeaFoodFormComponent', () => {
  let component: AccountRegisterFormComponent;
  let fixture: ComponentFixture<AccountRegisterFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccountRegisterFormComponent],
    });
    fixture = TestBed.createComponent(AccountRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
