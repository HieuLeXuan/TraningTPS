import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8081/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient) { }

  upload(file: File, description: string): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    formData.append('description', description);

    const req = new HttpRequest('POST', API_URL + 'images', formData, {
      reportProgress: true,
      responseType: 'json',
    });

    return this.http.request(req);
  }

  getListImages(): Observable<any> {
    return this.http.get(API_URL + 'images');
  }

  updateImage(image, id: string): Observable<any> {
    return this.http.put(`${API_URL}` + `images/${id}`, image, httpOptions)
  }

  deleteImage(id: string): Observable<any> {
    return this.http.delete(`${API_URL}` + `images/${id}`, { responseType: 'text' });
  }
}
