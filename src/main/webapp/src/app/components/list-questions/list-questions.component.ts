import { Component, OnInit } from '@angular/core';
import {QuestionService} from '../../service/question.service';
import{Question} from '../../question';
import{Router} from '@angular/router';
import { Examination } from '../../examination';
import { ActivatedRoute, Params, } from '@angular/router';
@Component({
  selector: 'app-list-questions',
  templateUrl: './list-questions.component.html',
  styleUrls: ['./list-questions.component.scss']
})
export class ListQuestionsComponent implements OnInit {
  private questions:Question[];
  private examination:Examination[];
  id;
  constructor(private _questionService:QuestionService, private _router:ActivatedRoute, private route:ActivatedRoute) { }
  ngOnInit() {

      this.route.params.forEach((params: Params) => {
          let id = +params['id']; // (+) converts string 'id' to a number
          this._questionService.getQuestions(this.id);
  //this.id=this._router.snapshot.params['id'];
   //   this._questionService.getQuestions(this.id);
  })
};
 //   this._questionService.getQuestion(this.examination.id).subscribe((examinations)=>{console.log(examinations);
    //  this.questions=this.questions;
   
  //  },
  //  (error)=>{console.log(error)}
  //  )
  
}
