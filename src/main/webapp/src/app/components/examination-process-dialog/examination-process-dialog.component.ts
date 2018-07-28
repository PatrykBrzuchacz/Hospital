import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { QuestionService } from '../../service/question.service';
import { Question } from './../../question';



@Component({
  selector: 'app-examination-process-dialog',
  templateUrl: './examination-process-dialog.component.html',
  styleUrls: ['./examination-process-dialog.component.scss']
})
export class ExaminationProcessDialogComponent implements OnInit {


  constructor(
    public dialogRef: MatDialogRef<ExaminationProcessDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private questionService: QuestionService) { }

//displayedColumns: string[] = ['name', 'value'];

  questions: Question[];

  ngOnInit() {
    this.questionService.getQuestions(this.data.examination.id).subscribe((questions) => {
      console.log(questions);
      this.questions = questions;
    });

  }




}