import {TestBed} from '@angular/core/testing';

import {SimperService} from './simper.service';

describe('SimperService', () =>
{
  let service: SimperService;

  beforeEach(() =>
  {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SimperService);
  });

  it('should be created', () =>
  {
    expect(service).toBeTruthy();
  });
});
