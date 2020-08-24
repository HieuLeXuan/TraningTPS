import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8090/';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  constructor(private http: HttpClient) {}

  getListUsers(): Observable<any> {
    return this.http.get(API_URL + 'users');
  }

  updateUser(user): Observable<any> {
    return this.http.put(API_URL + 'users', user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${API_URL}` + `users/${id}`);
  }
  
}
