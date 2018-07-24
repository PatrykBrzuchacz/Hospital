import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Question } from '../../question';
@Component({
  templateUrl: './my-dialog.component.html',

})
export class MyDialogComponent {

  constructor(
    private formBuilder: FormBuilder,
    private MyDialog: MatDialogRef<MyDialogComponent>
  ) {}
 
  questions = [];
  addQuestion(newQuestion: string) {
    if (newQuestion) {
      this.questions.push(newQuestion);
      console.log(newQuestion);
    }
    this.MyDialog.close();
    
  }

  




  // processFormExamination(){
  //   if(this.examination.id){
  //     this._examinationService.createExamination(this.examination).subscribe((examination)=>{
  //       console.log(examination);
  //       this.router.navigate(['/examinationList']);
  //     }, (error) => {console.log(error);
  //     });
  //   }
  //   else {
  //     this._examinationService.updateExamination(this.examination).subscribe((examination)=>{
  //       console.log(this.examination);
  //       this.router.navigate(['/examinationList']);
  //     });
  //   }

  // }


}


