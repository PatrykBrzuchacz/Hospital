import { TestBed, inject } from '@angular/core/testing';

import { ExaminationProcessService } from './examination-process.service';

describe('ExaminationProcessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaminationProcessService]
    });
  });

  it('should be created', inject([ExaminationProcessService], (service: ExaminationProcessService) => {
    expect(service).toBeTruthy();
  }));
});
