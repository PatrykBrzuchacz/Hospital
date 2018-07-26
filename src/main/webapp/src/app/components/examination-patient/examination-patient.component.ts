import { PatientService } from './../../service/patient.service';
import { ExaminationService } from './../../service/examination.service';
import { Examination } from './../../examination';
import { Patient } from './../../patient';
import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
@Component({
  selector: 'app-examination-patient',
  templateUrl: './examination-patient.component.html',
  styleUrls: ['./examination-patient.component.scss']
})
export class ExaminationPatientComponent implements OnInit {

  constructor(private examinationService: ExaminationService, private patientService: PatientService ) { }
allExaminations: Examination[] = [];
allPatients: Patient[] = [];

  ngOnInit() {
    this.initList();
  }

  initList() {
    this.examinationService.getExaminations().subscribe((res: any) => {
      this.allExaminations = res as Examination[];
    });

    this.patientService.getPatients().subscribe((res: any) => {
      this.allPatients = res as Patient[];
    });

  }
}
