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
  constructor(private _http:Http) {
  }
  getExaminations(){
   return this._http.get(this.baseUrl+'/examinations',this.options).map((response:Response)=>response.json())
   .catch(this.errorHandler);
}
errorHandler(error:Response){
  return Observable.throw(error||"SERVER ERROR");
  }
}
