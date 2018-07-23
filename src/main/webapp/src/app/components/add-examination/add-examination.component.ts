import { Component, OnInit } from '@angular/core';
import {Examination} from '../../examination';
import {ExaminationService} from '../../service/examination.service';
import{Router} from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material';

import { ActivatedRoute, Params, } from '@angular/router';
import { MyDialogComponent } from '../../my-dialog/my-dialog.component';


@Component({
  selector: 'app-add-examination',
  templateUrl: './add-examination.component.html',
  styleUrls: ['./add-examination.component.scss']
})
export class AddExaminationComponent implements OnInit {

  examination: Examination;
  private updateid: Number;


  constructor(private _examinationService:ExaminationService,private activatedRouter: ActivatedRoute, 
    private router: Router,public dialog: MatDialog) { }

  ngOnInit() {
    this.activatedRouter.paramMap.subscribe(params=>{
      const id = params.get('id');

      if (id) {
        this.updateid = +id;
        this._examinationService.getExaminationWithQuestions(this.updateid).subscribe(result => this.examination = result)
      }

    this.examination=this._examinationService.getter();
  })
}
 
  processFormExamination(){
    if(this.examination.id){
      this._examinationService.createExamination(this.examination).subscribe((examination)=>{
        console.log(examination);
        this.router.navigate(['/examinationList']);
      }, (error) => {console.log(error);
      });
    }
    else {
      this._examinationService.updateExamination(this.examination).subscribe((examination)=>{
        console.log(this.examination);
        this.router.navigate(['/']);
      });
    }

  }

  MyDialogRef: MatDialogRef<MyDialogComponent>;

  openDialog() {
    this.MyDialogRef = this.dialog.open(MyDialogComponent,{
      hasBackdrop: false
    });
  }

  
}
