import { TestBed } from '@angular/core/testing';

import { DelegateFiltersService } from './delegate-filters.service';

describe('DelegateFiltersService', () => {
  let service: DelegateFiltersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DelegateFiltersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
