import { Component, OnInit } from '@angular/core';
import {Patient} from '../../patient';
import {PatientService} from '../../service/patient.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.scss']
})
export class AddPatientComponent implements OnInit {
private patient: Patient;

  constructor(private _patientService: PatientService, private _router: Router) { 

  }

  ngOnInit() {
    this.patient = this._patientService.getter();
  }
processForm() {
  if (this.patient.id === undefined) {
    this._patientService.createPatient(this.patient).subscribe((patient) => {
      console.log(patient);
      this._router.navigate(['/']);
    }, (error) => {console.log(error);
    });
  } else {
      this._patientService.updatePatient(this.patient).subscribe((patient) => {
        console.log(patient);
        this._router.navigate(['/']);
      }, (error) => {console.log(error);
      });
  }
}
}
