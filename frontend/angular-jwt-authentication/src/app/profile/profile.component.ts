import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class ProfileComponent implements OnInit {
  
  currentUser: any;
  user: User;

  constructor(private userService: UserService, private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
  }

  save(): void {
    // this.userService.updateUser(this.user).subscribe();
    console.log(this.user.firstname);
  }

  reset() {

  }
}