import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { Router } from '@angular/router';
import { Examination } from '../../../domain/examination';
import { Question } from '../../../domain/question';
import { ExaminationService } from '../../../service/examination.service';
import { QuestionService } from '../../../service/question.service';

@Component({
  selector: 'app-new-examination-dialog',
  templateUrl: './new-examination-dialog.component.html',
  styleUrls: ['./new-examination-dialog.component.scss']
})



export class NewExaminationDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<NewExaminationDialogComponent>, private examinationService: ExaminationService,
    private router: Router, private formBuilder: FormBuilder, private questionService: QuestionService) {
    this.initNewExaminationForm();
    this.initQuestionForm();
  }

  newExaminationForm: FormGroup;
  questionForm: FormGroup;
  examination: Examination;
  question: Question;
  questionList: Question[] = [];

  types: Types[] = [
    { value: 'MORFOLOGIA' },
    { value: 'REZONANS' },
    { value: 'TOMOGRAFIA' }
  ];

  ngOnInit() {
    this.initExamination();
    this.initQuestion();
  }

  initNewExaminationForm(): any {
    this.newExaminationForm = this.formBuilder.group({
      name: ['', Validators.required],
      type: ['', Validators.required]
    });
  }

  initQuestionForm(): any {
    this.questionForm = this.formBuilder.group({
      name: ['']
    });
  }

  initExamination() {
    this.examination = { id: null, name: null, type: null, questions: null };
  }

  initQuestion() {
    this.question = { id: null, name: null, examination: null };
  }


  saveExamination() {
    this.examinationService.createExamination(this.examination).subscribe((examination) => {
      console.log("zapisano examination");

      console.log(examination);

      for (let i = 0; i < this.questionList.length; i++) {
        this.questionList[i].examination = this.examination;
        console.log("lista question po dodaniu jednego");

        console.log(this.questionList[i]);
      }

      console.log("cala lista question list");
      console.log(this.questionList);


  
      this.questionService.addAll(this.questionList, examination.id).subscribe((questionRes: any) => {
        this.questionList = questionRes as Question[];
        for (let i = 0; i < this.questionList.length; i++) {

          console.log(this.questionList[i]);
        }
        console.log("questiony przypisane");

        this.questionList = [];
      }
    )
    });
  
    
    
  }

  addQuestion(questionName) {
    this.question = new Question(null, questionName);
    this.questionList.push(this.question);
    this.questionForm.reset();
    console.log("Question added to questionList");
  }

  createQuestion() {

  }

}

export interface Types {
  value: string;
}
