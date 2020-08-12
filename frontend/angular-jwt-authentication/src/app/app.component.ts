import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['../assets/css/styles.css']
})
export class AppComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  username: string;

  currentUser: any;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.currentUser = this.tokenStorageService.getUser();
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.username = user.username;
    }

    $(".menu-toggle").click(function(e) {
      e.preventDefault();
      $("#sidebar-wrapper").toggleClass("active");
      $(".menu-toggle > .fa-bars, .menu-toggle > .fa-times").toggleClass("fa-bars fa-times");
      $(this).toggleClass("active");
    });

  }

  logout() {
    this.tokenStorageService.signOut();
    // window.location.reload();
    window.location.replace("home");
  }
}