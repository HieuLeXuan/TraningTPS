import { Component, OnInit } from '@angular/core';
import { ImageService } from '../_services/image.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { Image } from '../model/image';
import { Observable } from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  images: Observable<Image[]>;
  currentUser: any;

  constructor(private imageService: ImageService, private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.reload();
  }
  
  reload(){
    this.images = this.imageService.getListImages();
  }
}