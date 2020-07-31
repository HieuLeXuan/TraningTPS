import { Component, OnInit } from '@angular/core';
import { ImageService } from '../_services/image.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { Image } from '../model/image';
import { Observable } from "rxjs";
import { HttpClient, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  images: Observable<Image[]>;
  currentUser: any;
  base64textString: string;

  constructor(private imageService: ImageService, private http: HttpClient, private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.reload();
  }
  
  reload(){
    this.images = this.imageService.getListImages();
  }

  // async requestAndEncode(url) {
  //   return this.http.get(url).toPromise().then((res: HttpResponse<any>) => btoa(res.body));
  // }
}