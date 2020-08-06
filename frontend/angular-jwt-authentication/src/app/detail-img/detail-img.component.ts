import { Component, OnInit, Input } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { Image } from '../model/image';

@Component({
  selector: 'app-detail-img',
  templateUrl: './detail-img.component.html',
  styleUrls: ['./detail-img.component.css']
})
export class DetailImgComponent implements OnInit {

  currentUser: any;
  @Input() image: Image;

  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
  }

}
