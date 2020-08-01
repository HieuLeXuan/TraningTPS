import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { ImageService } from '../_services/image.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css'],
})
export class BoardAdminComponent implements OnInit {
  content = '';
  currentUser: any;

  constructor(
    private userService: UserService,
    private token: TokenStorageService
  ) {}

  ngOnInit() {
    this.currentUser = this.token.getUser();
    // this.userService.getAdminBoard().subscribe(
    //   (data) => {
    //     this.content = data;
    //   },
    //   (err) => {
    //     this.content = JSON.parse(err.error).message;
    //   }
    // );
  }
}
