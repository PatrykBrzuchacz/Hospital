import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Patient } from '../../../domain/Patient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PatientService } from '../../../service/patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-patient-dialog',
  templateUrl: './update-patient-dialog.component.html',
  styleUrls: ['./update-patient-dialog.component.scss']
})
export class UpdatePatientDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<UpdatePatientDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private patientService: PatientService,
    private router: Router) {
    this.initUpdatePatientForm();
  }

  updatePatientForm: FormGroup;
  patient: Patient;



  ngOnInit() {
    console.log(this.data.patient.name);
    this.patient = this.data.patient;
  }

  initUpdatePatientForm() {
    this.updatePatientForm = this.formBuilder.group({
      name: ['', Validators.required],
      pesel: ['', [Validators.required]],
    });
  }

  updatePatient() {
    this.patientService.updatePatient(this.patient).subscribe((patient) => {
      console.log(patient);
      this.dialogRef.close();
      this.router.navigate(['/']);
    }, (error) => {
      console.log(error);
    });
  }

}


