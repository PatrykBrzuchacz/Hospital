import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListExaminationComponent } from './list-examination.component';

describe('ListExaminationComponent', () => {
  let component: ListExaminationComponent;
  let fixture: ComponentFixture<ListExaminationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListExaminationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListExaminationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});