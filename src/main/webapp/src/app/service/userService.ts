import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import {Observable} from 'rxjs/Observable';
import { User } from "src/app/domain/user";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {}

  private baseUrl = '/api';

  public user = new User();

  createUser(user:User){
    return this.http.post(this.baseUrl+ '/save', user);
  }

}
