import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExaminationWithQuestionsComponent } from './examination-with-questions.component';

describe('ExaminationWithQuestionsComponent', () => {
  let component: ExaminationWithQuestionsComponent;
  let fixture: ComponentFixture<ExaminationWithQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExaminationWithQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExaminationWithQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
