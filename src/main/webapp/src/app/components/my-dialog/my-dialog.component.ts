import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Question } from '../../question';
import { QuestionService } from '../../service/question.service';
@Component({
  templateUrl: './my-dialog.component.html',

})
export class MyDialogComponent {

  private question:Question;

  constructor(
    private formBuilder: FormBuilder,
    private MyDialog: MatDialogRef<MyDialogComponent>,
    private questionService:QuestionService
  ) {}
 
  questions = [];
  addQuestion(nameQuestion: string) {
    if (nameQuestion) {
     // this.questions.push(nameQuestion);
      let question = new Question();
      
      question.name=nameQuestion;
      console.log(question);
      this.questionService.createQuestion(this.question,1).subscribe((question)=>{
        console.log(question);
       // this._router.navigate(['/']);
      });
      //  this.questionService.createQuestion(question, 1);
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


