import { Component, OnInit } from '@angular/core';
import { ExaminationService } from '../../../service/examination.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { Examination } from '../../../domain/examination';

@Component({
  selector: 'app-examinations-list',
  templateUrl: './examinations-list.component.html',
  styleUrls: ['./examinations-list.component.scss']
})
export class ExaminationsListComponent implements OnInit {

  constructor(private examinationService: ExaminationService, private router: Router, public dialog: MatDialog) { }

  displayedColumns: string[] = ['id', 'name', 'type', 'show questions', 'delete'];
  public examinations: Examination[];

  ngOnInit() {
    this.examinationService.getExaminations().subscribe((examinations) => {
      this.examinations = examinations;
      console.log(examinations);
    })   
  }

  deleteExamination(examination){
    console.log(examination.id);
    this.examinationService.delete(examination.id).subscribe((data) => {
      this.examinations.splice(this.examinations.indexOf(examination), 1);
      this.router.navigate(['/']);

    }, (error) => {console.log(error); }
  );
  }

  showQuestion(){

  }

}
