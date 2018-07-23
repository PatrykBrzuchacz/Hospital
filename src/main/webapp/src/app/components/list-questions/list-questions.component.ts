import { Component, OnInit } from '@angular/core';
import {QuestionService} from '../../service/question.service';
import{Question} from '../../question';
import{Router} from '@angular/router';
import { Examination } from '../../examination';
@Component({
  selector: 'app-list-questions',
  templateUrl: './list-questions.component.html',
  styleUrls: ['./list-questions.component.scss']
})
export class ListQuestionsComponent implements OnInit {
  private questions:Question[];
  private examination:Examination[];
  constructor(private _questionService:QuestionService, private _router:Router) { }
  ngOnInit() {
    this._questionService.getQuestion(this.examination.id).subscribe((examinations)=>{console.log(examinations);
      this.questions=this.questions;
   
    },
    (error)=>{console.log(error)}
    )
  }
}
