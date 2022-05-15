import { TestBed } from '@angular/core/testing';

import { StoryWorkerService } from './story-worker.service';

describe('NewsWorkerService', () => {
  let service: StoryWorkerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StoryWorkerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
