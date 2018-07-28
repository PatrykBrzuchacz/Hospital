import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExaminationProcessDialogComponent } from './examination-process-dialog.component';

describe('ExaminationProcessDialogComponent', () => {
  let component: ExaminationProcessDialogComponent;
  let fixture: ComponentFixture<ExaminationProcessDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExaminationProcessDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExaminationProcessDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
