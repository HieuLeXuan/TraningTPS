import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8081/api/load/';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient) { }

  upload(file: File, description: string): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    formData.append('description', description);

    const req = new HttpRequest('POST', API_URL + 'upload', formData, {
      reportProgress: true,
      responseType: 'json',
    });

    return this.http.request(req);
  }

  getListImages(): Observable<any> {
    return this.http.get(API_URL + 'files');
  }
}
