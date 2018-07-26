import { ExaminationService } from './../../service/examination.service';
import { Component, OnInit, Input } from '@angular/core';
import {QuestionService} from '../../service/question.service';
import {Question} from '../../question';
import {Router} from '@angular/router';
import { Examination } from '../../examination';
import { ActivatedRoute, Params, } from '@angular/router';
@Component({
  selector: 'app-list-questions',
  templateUrl: './list-questions.component.html',
  styleUrls: ['./list-questions.component.scss']
})
export class ListQuestionsComponent implements OnInit {
  @Input() examination: Examination;
updateid: Number;
  constructor(private router: ActivatedRoute, private examinationService: ExaminationService) { }
  ngOnInit() {
      this.router.paramMap.subscribe(params => {
        this.updateid = parseInt(params.get('id'), 2);
        this.examinationService.getExaminationWithQuestions(this.updateid).subscribe(result => this.examination = result);
   });
}
}
