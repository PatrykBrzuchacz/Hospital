import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';
import{Patient}  from '../patient';
@Injectable()
export class PatientService {
private baseUrl:string='http://localhost:8080/api';
private headers = new Headers({'Content-Type':'application/json'});
private options= new RequestOptions({headers:this.headers});
private patient = new Patient();
  constructor(private _http:Http) {
   }
   getPatients(){
    return this._http.get(this.baseUrl+'/patients',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
}
createPatient(patient:Patient){
  return this._http.post(this.baseUrl+'/patients',JSON.stringify(patient), this.options).map((response:Response)=>response.json())
  .catch(this.errorHandler);
}
deletePatient(id:Number){
  return this._http.delete(this.baseUrl+'/patient/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
}
updatePatient(patient:Patient){
  return this._http.put(this.baseUrl+'/patients',JSON.stringify(patient),  this.options).map((response:Response)=>response.json())
  .catch(this.errorHandler);
}

errorHandler(error:Response){
return Observable.throw(error||"SERVER ERROR");
}

setter(patient:Patient){
this.patient=patient;
}
getter(){
  return this.patient;
}
}