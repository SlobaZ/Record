import { TestBed } from '@angular/core/testing';

import { RecordValueService } from './recordvalue.service';

describe('RecordValueService', () => {
  let service: RecordValueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecordValueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
