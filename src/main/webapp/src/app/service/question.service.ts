import { Injectable } from '@angular/core';
// import 'rxjs/add/operator/map';
// import 'rxjs/add/operator/catch';
// import 'rxjs/add/observable/throw';
// tslint:disable-next-line:import-spacing
import{Question}  from '../domain/question';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable()
export class QuestionService {


  private baseUrl = 'api/question/';
  constructor(private http: HttpClient) {
  }

  getQuestions(id: Number): Observable<Question[]> {
    return this.http.get<Question[]>(this.baseUrl  + id);
<<<<<<< HEAD
  } 
  
  
}
=======
  }
  addAll(questions: Question[], id: number): Observable<Question[]> {
    return this.http.post<Question[]>(this.baseUrl+'examination/' + id + '/add', questions);
  }
}
>>>>>>> branch-1.0
