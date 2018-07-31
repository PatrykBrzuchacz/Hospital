import { Injectable, EventEmitter } from "../../../node_modules/@angular/core";
import { Patient } from "../domain/patient";

@Injectable()
export class CustomEventEmitter {
    addPatientEmitter: EventEmitter<Patient> = new EventEmitter<Patient>();
}