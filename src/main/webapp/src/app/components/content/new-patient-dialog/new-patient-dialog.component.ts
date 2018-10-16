import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../../service/patient.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Patient } from '../../../domain/patient';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-new-patient-dialog',
  templateUrl: './new-patient-dialog.component.html',
  styleUrls: ['./new-patient-dialog.component.scss']
})
export class NewPatientDialogComponent implements OnInit {


  constructor(public dialogRef: MatDialogRef<NewPatientDialogComponent>,private patientService: PatientService, private router: Router, private formBuilder: FormBuilder) {
    this.initNewPatientForm();
  }

  newPatientForm: FormGroup;
  patient: Patient;

  ngOnInit() {
    this.initPatient();
  }

  initNewPatientForm(): any {
    this.newPatientForm = this.formBuilder.group({
      name: ['', Validators.required],
      pesel: ['', [Validators.required]],
    })
  }

  initPatient() {
    this.patient = { id: null, name: null, pesel: null };
  }


  registerPatient() {
    this.patientService.createPatient(this.patient).subscribe((patient) => {
      console.log(patient);
      this.router.navigate(['']);
      this.dialogRef.close();

    }, (error) => {
      console.log(error);
    });
  }

}
