import { Component, OnInit } from '@angular/core';
import {Examination} from '../../examination';
import {ExaminationService} from '../../service/examination.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-add-examination',
  templateUrl: './add-examination.component.html',
  styleUrls: ['./add-examination.component.scss']
})
export class AddExaminationComponent implements OnInit {

  private examination:Examination;


  constructor(private _examinationService:ExaminationService,private _router:Router) { }

  ngOnInit() {
    this.examination=this._examinationService.getter();
  }

 

  processFormExamination(){
    if(this.examination.id==undefined){
      this._examinationService.createExamination(this.examination).subscribe((examination)=>{
        console.log(examination);
        this._router.navigate(['/examinationList']);
      }, (error) => {console.log(error);
      });
    }
    else {
      this._examinationService.updateExamination(this.examination).subscribe((examination)=>{
        console.log(this.examination);
        this._router.navigate(['/']);
      });
    }

  }

}
