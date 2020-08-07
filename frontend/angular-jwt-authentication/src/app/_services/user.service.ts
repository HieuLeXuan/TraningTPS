import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { User } from '../model/user';

// const API_URL = 'http://localhost:8081/api/login/';
const API_URL = 'http://localhost:8081/api/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }

  updateUser(file: File, user: User): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    // formData.append('user', user);

    const req = new HttpRequest('PUT', API_URL + 'uses', formData, {
      reportProgress: true,
      responseType: 'json',
    });
    return this.http.request(req);
  }
}