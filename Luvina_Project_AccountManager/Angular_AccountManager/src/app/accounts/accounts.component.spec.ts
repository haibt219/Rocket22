import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeaFoodsComponent } from './accounts.component';

describe('EmployeesComponent', () => {
  let component: SeaFoodsComponent;
  let fixture: ComponentFixture<SeaFoodsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeaFoodsComponent],
    });
    fixture = TestBed.createComponent(SeaFoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
