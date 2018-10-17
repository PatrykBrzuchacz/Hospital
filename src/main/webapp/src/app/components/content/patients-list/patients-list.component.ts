import { Component, OnInit } from '@angular/core';
import { Patient } from '../../../domain/Patient';
import { PatientService } from '../../../service/patient.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { UpdatePatientDialogComponent } from '../update-patient-dialog/update-patient-dialog.component';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.scss']
})
export class PatientsListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'pesel', 'edit', 'delete'];
  public patients: Patient[];

  constructor(private patientService: PatientService, private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.patientService.getPatients().subscribe((patients) => {
      this.patients = patients;
      console.log(patients);
    })
  }

  updatePatient(patient) {
    const dialogRef = this.dialog.open(UpdatePatientDialogComponent, {
      width: '400px',
      data: { patient: patient },
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  deletePatient(patient){
    console.log(patient.id);
    this.patientService.deletePatient(patient.id).subscribe((data) => {
      this.patients.splice(this.patients.indexOf(patient), 1);
      this.router.navigate(['/']);

    }, (error) => {console.log(error); }
  );
  }


  
    

}


