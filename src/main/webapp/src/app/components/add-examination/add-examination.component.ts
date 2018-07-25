import { Component, OnInit } from '@angular/core';
import {Examination} from '../../examination';
import {ExaminationService} from '../../service/examination.service';
import {Router} from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material';
import { FormControl, FormGroup, FormArray, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Params, } from '@angular/router';
import  {Question } from '../../question';
import { filter } from 'rxjs/operators';
import { QuestionService } from '../../service/question.service';

@Component({
  selector: 'app-add-examination',
  templateUrl: './add-examination.component.html',
  styleUrls: ['./add-examination.component.scss']
})
export class AddExaminationComponent implements OnInit {

  constructor(private examinationService: ExaminationService,
     private activatedRouter: ActivatedRoute,
    private questionService: QuestionService,
     private router: Router, private fb: FormBuilder) { }
updateid:number;
     examination: Examination;
     question: Question;
     examinationForm:FormGroup;
     questionForm:FormGroup;
questionList:Question[]=[];

ngOnInit(){
  this.createForms();
  this.initList();
}
createForms(){
  this.examinationForm=this.fb.group({
    name:'',
    type:'',
  });
  this.questionForm=this.fb.group({
    questionName:''
  })
}

initList(){
        this.activatedRouter.paramMap.subscribe(params => {
        const id = params.get('id');
        if (id) {
          this.updateid = +id;
        this.examinationService.getExaminationWithQuestions(this.updateid).
        subscribe(result => this.examination = result);
        
}});
}
onQuestionSumbit(value:any){
  let questionName=value.questionName;
  value.questionName.trim();
  const Q: Question = new Question(null, questionName);
  this.questionList.push(Q);
  this.questionForm.reset();
}
onExaminationSubmit(){
  const exName=this.examinationForm.value.name.trim();
  const exType=this.examinationForm.value.type.trim();
const questionsOnExamination = this.questionList.length;
  let examination: Examination=new Examination(exName, exType);
  this.examinationService.createExamination(examination).subscribe((examinationRes:any)=>{
    examination=examinationRes as Examination;

    for (let i=0; i<this.questionList.length;i++) {
      this.questionList[i].examination=examination;
    }
    this.questionService.addAll(this.questionList,examination.id).subscribe((questionRes:any)=>{
      this.questionList=questionRes as Question[];
      this.examinationForm.reset();
    this.questionList=[];
    }
  )

  })
}
  }






   //ngOnInit() {
    //   this.activatedRouter.paramMap.subscribe(params => {
    //     const id = params.get('id');
    //     if (id) {
    //       this.updateid = +id;
    //       this._examinationService.getExaminationWithQuestions(this.updateid).subscribe(result => this.examination = result);
    //     }
    
    // });
    // this.createExaminationForm();
  


// get empFormArray(): FormArray{
//   return this.examinationForm.get('questions') as FormArray;
// }
// addQuestion(){
//   let fg = this.fb.group(new Question());
//   this.empFormArray.push(fg);	  
// }

  
//   processFormExamination() {
//     if (this.examination.id) {
//       this._examinationService.createExamination(this.examination).subscribe((examination) => {
//         console.log(examination);
//         this.router.navigate(['/examinationList']);
//       }, (error) => {console.log(error);
//       });
//     } else {
//       this._examinationService.updateExamination(this.examination).subscribe((examination) => {
//         console.log(this.examination);
//         this.router.navigate(['/examinationList']);
//       });
//     }

//   }

// }
