import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User_Permission } from '../model/user_permission';

const API_URL = 'http://localhost:8081/';

@Injectable({
  providedIn: 'root'
})
export class PermissionService {

  constructor(private http: HttpClient) { }

  getListPermissions(): Observable<any> {
    return this.http.get<any>(API_URL + 'permissions');
  }

  setPermissions(u_p : User_Permission, user_id : number, permission_id : number): Observable<any> {
    return this.http.post(`${API_URL}` + `permissions?user_id=` + `${user_id}` + `&permission_id=` + `${permission_id}`, u_p);
  }
}
