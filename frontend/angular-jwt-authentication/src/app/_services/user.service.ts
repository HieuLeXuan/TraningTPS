import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from "rxjs/operators";
import { Router } from '@angular/router';

const API_URL = 'http://localhost:8080/api/login/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', {responseType: "text"});
  }
}