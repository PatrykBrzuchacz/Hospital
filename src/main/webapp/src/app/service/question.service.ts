import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';
// tslint:disable-next-line:import-spacing
import{Question}  from '../question';
import { HttpClient } from '@angular/common/http';
import {Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import {Examination} from '../examination';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  // private baseUrlProxyShouldBe: string='http://localhost:8080/'; //todo proxy

  private baseUrl = 'api/question/';
  constructor(private http: HttpClient) {
  }

  getQuestions(id: Number): Observable<Question[]> {
    return this.http.get<Question[]>(this.baseUrl  + id);
  }
  addAll(questions: Question[], id: number): Observable<Question[]> {
    return this.http.post<Question[]>(this.baseUrl+'examination/' + id + '/add', questions);
  }
}
