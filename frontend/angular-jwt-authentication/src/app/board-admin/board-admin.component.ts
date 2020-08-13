import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { ImageService } from '../_services/image.service';
import { Observable } from 'rxjs';
import { UserService } from '../_services/user.service';
import { Image } from '../model/image';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['../../assets/css/styles.css'],
})
export class BoardAdminComponent implements OnInit {

  currentUser: any;
  images: Observable<any>;
  users: Observable<any>;

  selectedImage: Image;

  constructor(
    private imageService: ImageService,
    private userService: UserService,
    private token: TokenStorageService
  ) {}

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.images = this.imageService.getListImages();
    this.users = this.userService.getListsers();
  }

  onSelect(image: Image): void {
    this.selectedImage = image;
  }
}
