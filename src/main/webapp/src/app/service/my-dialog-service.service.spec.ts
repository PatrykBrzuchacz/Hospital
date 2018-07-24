import { TestBed, inject } from '@angular/core/testing';

import { MyDialogServiceService } from './my-dialog-service.service';

describe('MyDialogServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MyDialogServiceService]
    });
  });

  it('should be created', inject([MyDialogServiceService], (service: MyDialogServiceService) => {
    expect(service).toBeTruthy();
  }));
});
