import { TestBed } from '@angular/core/testing';

import { NewsWorkerService } from '../core/services/news-worker.service';

describe('NewsWorkerService', () => {
  let service: NewsWorkerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewsWorkerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
