import { PatientService } from './../../service/patient.service';
import { ExaminationService } from './../../service/examination.service';
import { Examination } from './../../examination';
import { Patient } from './../../patient';
import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { log } from 'util';
@Component({
  selector: 'app-examination-patient',
  templateUrl: './examination-patient.component.html',
  styleUrls: ['./examination-patient.component.scss']
})
export class ExaminationPatientComponent implements OnInit {

  constructor(private examinationService: ExaminationService, private patientService: PatientService) { }
 
  examinations: Examination[];
  public patients: Patient[];

  ngOnInit() {
    this.examinationService.getExaminations().subscribe((examinations) => {
      console.log(examinations);
      this.examinations = examinations;
    });

      this.patientService.getPatients().subscribe((patients) => {
        console.log(patients);
        this.patients = patients;
      });
        
      

     

  }

}
