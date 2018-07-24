import { Component, OnInit, Input } from '@angular/core';
import {QuestionService} from '../../service/question.service';
import {Question} from '../../question';
import {Router} from '@angular/router';
import { Examination } from '../../examination';
import { ActivatedRoute, Params, } from '@angular/router';
import { ExaminationService } from '../../service/examination.service';
@Component({
  selector: 'app-list-questions',
  templateUrl: './list-questions.component.html',
  styleUrls: ['./list-questions.component.scss']
})
export class ListQuestionsComponent implements OnInit {
  @Input() examination: Examination;

  constructor() { }
  ngOnInit() {
    //  this._router.paramMap.subscribe(params=>{
    //    this.updateid = parseInt(params.get('id'));
    //    this.examinationService.getExaminationWithQuestions(this.updateid).subscribe(result => this.examination = result)
  // })
}
}
