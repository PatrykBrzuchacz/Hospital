import { Component, OnInit, Input } from '@angular/core';
import {ExaminationService} from '../../service/examination.service';
import{Examination} from '../../examination';
import{Router} from '@angular/router';
import {QuestionService} from '../../service/question.service';
import{Question} from '../../question';

@Component({
  selector: 'app-list-examination',
  templateUrl: './list-examination.component.html',
  styleUrls: ['./list-examination.component.scss']
})
export class ListExaminationComponent implements OnInit {
private examinations:Examination[];

  constructor(private _examinationService:ExaminationService, private _router:Router) { }
  
  ngOnInit() {
   this._examinationService.getExaminations().subscribe((examinations)=>{console.log(examinations);
     this.examinations=examinations;})
  }
onSelect(examination){
  this._router.navigate(['/examinationList/upsert/',examination.id]);
  }
  createExamination(){
    let examination = new Examination();
    this._examinationService.setter(examination);
    this._router.navigate(['/examinationList/upsert']);
  }




}

