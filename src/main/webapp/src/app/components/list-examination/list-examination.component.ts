import { Component, OnInit, Input } from '@angular/core';
import {ExaminationService} from '../../service/examination.service';
import {Examination} from '../../examination';
import {Router} from '@angular/router';
import {QuestionService} from '../../service/question.service';


@Component({
  selector: 'app-list-examination',
  templateUrl: './list-examination.component.html',
  styleUrls: ['./list-examination.component.scss']
})
export class ListExaminationComponent implements OnInit {
private examinations: Examination[];

  @Input() examination: Examination;

  constructor(private examinationService: ExaminationService, private _router: Router) { }
  ngOnInit() {
   this.examinationService.getExaminations().subscribe((examinations) => {console.log(examinations);
     this.examinations = examinations; });
  }
onSelect(examination) {
  this._router.navigate(['/examinationList/upsert', examination.id]);
  }
  createExamination() {
    this._router.navigate(['/examinationList/upsert']);
  }

  deleteExamination(index: number) {
    this.examinationService.delete(this.examinations[index].id);

    delete this.examinations[index];

    for (let i = index; i < this.examinations.length; i++) {
      this.examinations[i] = this.examinations[i + 1];
    }

    this.examinations.pop();
  }
}




