import { TestBed } from '@angular/core/testing';

import { CalculateResultService } from './calculate-result.service';

describe('CalculateResultService', () => {
  let service: CalculateResultService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculateResultService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
