import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointState, BreakpointObserver } from '@angular/cdk/layout';
import { MatDialog } from '@angular/material';
import { NewPatientDialogComponent } from '../new-patient-dialog/new-patient-dialog.component';
import { NewExaminationDialogComponent } from '../new-examination-dialog/new-examination-dialog.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {


  constructor(public dialog: MatDialog) { }


  newPatient() {
    const dialogRef = this.dialog.open(NewPatientDialogComponent, {
      width: '400px',
    });
    dialogRef.afterClosed().subscribe(result => {

      console.log('The dialog was closed');
    });
  }

  newExamination() {
    const dialogRef = this.dialog.open(NewExaminationDialogComponent, {
      width: '500px',
    });
    dialogRef.afterClosed().subscribe(result => {

      console.log('The dialog was closed');
    });

  }
}
