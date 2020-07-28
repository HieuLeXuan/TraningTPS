import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from "rxjs/operators";
import { Router } from '@angular/router';

const API_URL = 'http://localhost:8080/api/upload/';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient, private router: Router) { }

  getListImages(): Observable<any> {
    return this.http.get(API_URL + 'all');
  }
}
