import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class ProfileComponent implements OnInit {
  
  currentUser: any;
  copyOfCurrentUser: any;
  textProfile = false;

  constructor(private userService: UserService, private token: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.currentUser.password = '';
    this.copyOfCurrentUser = { ...this.currentUser };
  }

  save(): void {
    const { username, firstname, lastname, phone, email, location} = this.copyOfCurrentUser;
    this.userService.updateUser({ username, firstname, lastname, phone, email, location}).subscribe(
      respones => {
        this.currentUser = { ... this.copyOfCurrentUser};
        this.logout();
        }
    );
  }

  reset() {
    this.copyOfCurrentUser = { ...this.currentUser };
  }

  beginEdit(): void {
    this.textProfile = true;
    this.copyOfCurrentUser = { ...this.currentUser };
  }

  logout() {
    this.token.signOut();
    window.location.replace("home");
  }
}