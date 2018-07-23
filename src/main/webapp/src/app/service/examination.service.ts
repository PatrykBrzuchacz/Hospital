import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';
import{Examination}  from '../examination';
@Injectable()
export class ExaminationService {
  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options= new RequestOptions({headers:this.headers});
  private examination = new Examination();
  constructor(private _http:Http) {
  }
  getExaminations(){
   return this._http.get(this.baseUrl+'/examinations',this.options).map((response:Response)=>response.json())
   .catch(this.errorHandler);
}
errorHandler(error:Response){
  return Observable.throw(error||"SERVER ERROR");
  }
  //createPatient(patient:Patient){
   // return this._http.post(this.baseUrl+'/patients',JSON.stringify(patient), this.options).map((response:Response)=>response.json())
   // .catch(this.errorHandler);
  //}
  createExamination(examination:Examination){
    return this._http.post(this.baseUrl+'/examinations',JSON.stringify(examination), this.options).map((response:Response)=>response.json())
   // .catch(this.errorHandler);
  }

  updateExamination(examination:Examination){
    return this._http.put(this.baseUrl+'/examinations',JSON.stringify(examination),  this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  setter(examination:Examination){
    this.examination=examination;
    }

    getter() {
    return this.examination;
    }
}
