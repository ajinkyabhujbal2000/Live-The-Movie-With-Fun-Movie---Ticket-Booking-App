import { TestBed } from '@angular/core/testing';

import { TheatreService } from './theatre.service';

describe('theatreService', () => {
  let service: TheatreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TheatreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
