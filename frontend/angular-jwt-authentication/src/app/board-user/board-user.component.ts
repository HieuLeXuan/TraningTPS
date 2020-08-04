import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { ImageService } from '../_services/image.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css'],
})
export class BoardUserComponent implements OnInit {

  currentUser: any;
  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';
  
  isLoggedIn = false;
  descript: string;
  username: string;
  id: string;

  constructor(
    private token: TokenStorageService,
    private imageService: ImageService,
  ) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.isLoggedIn = !!this.token.getToken();

    if (this.isLoggedIn) {
      const user = this.token.getUser();
      this.username = user.username;
      this.id = user.id;
    }
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
    this.progress = 0;
    this.message='';
  }

  upload() {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.imageService.upload(this.currentFile, this.descript).subscribe(
      (event) => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round((100 * event.loaded) / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
        }
      },
      (err) => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      }
    );
    this.selectedFiles = undefined;
  }
  description(currentFile: File, description: any) {
    throw new Error("Method not implemented.");
  }
}
