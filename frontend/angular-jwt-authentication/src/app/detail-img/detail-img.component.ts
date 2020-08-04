import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ImageService } from '../_services/image.service';
import { Image } from '../model/image';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-detail-img',
  templateUrl: './detail-img.component.html',
  styleUrls: ['./detail-img.component.css']
})
export class DetailImgComponent implements OnInit {

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
