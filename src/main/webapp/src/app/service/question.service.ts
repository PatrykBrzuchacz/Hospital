import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';
import{Question}  from '../question';
@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options= new RequestOptions({headers:this.headers});
  private question = new Question();
    constructor(private _http:Http) {
     }
     getQuestion(id:Number){
      return this._http.get(this.baseUrl+'/question/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
    }
  
}