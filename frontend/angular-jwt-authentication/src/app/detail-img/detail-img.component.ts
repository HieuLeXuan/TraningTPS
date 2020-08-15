import { Component, OnInit, Input } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { Image } from '../model/image';
import { ImageService } from '../_services/image.service';

@Component({
  selector: 'app-detail-img',
  templateUrl: './detail-img.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class DetailImgComponent implements OnInit {

  currentUser: any;
  @Input() image: Image;

  constructor(private token: TokenStorageService, private imageService: ImageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
  }
}
