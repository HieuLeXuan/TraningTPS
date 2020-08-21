import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class RequestinterceptorService implements HttpInterceptor {

  constructor(private tokenStorage: TokenStorageService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
     // Get JWT token form LocalStorage and set it to Headers
     const token = this.tokenStorage.getToken();
     console.log(token);
     if (token) {
      req = req.clone({
         setHeaders: {
           Authorization: `Bearer ${token}`,
         },
       });
     }
     return next.handle(req);
   }
}
