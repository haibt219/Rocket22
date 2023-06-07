import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountUpdateFormComponent } from './account-update-form.component';

describe('AccountUpdateFormComponent', () => {
  let component: AccountUpdateFormComponent;
  let fixture: ComponentFixture<AccountUpdateFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccountUpdateFormComponent]
    });
    fixture = TestBed.createComponent(AccountUpdateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
