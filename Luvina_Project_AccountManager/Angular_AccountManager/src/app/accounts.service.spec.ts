import { TestBed } from '@angular/core/testing';

import { SeaFoodsService } from './accounts.service';

describe('EmployeesService', () => {
  let service: SeaFoodsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeaFoodsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
