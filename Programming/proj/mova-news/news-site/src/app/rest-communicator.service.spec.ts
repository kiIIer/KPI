import { TestBed } from '@angular/core/testing';

import { RestCommunicatorService } from './rest-communicator.service';

describe('RestCommunicatorService', () => {
  let service: RestCommunicatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestCommunicatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
