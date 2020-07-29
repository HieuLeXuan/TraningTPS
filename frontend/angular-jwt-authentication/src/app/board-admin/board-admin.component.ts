import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  content = '';
  currentUser: any;

  constructor(private userService: UserService, private token: TokenStorageService, private router: Router) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.userService.getAdminBoard().subscribe(
      data => {
        this.content = data;
      },
      err => { 
        this.content = JSON.parse(err.error).message;
      }
    );
  }
}