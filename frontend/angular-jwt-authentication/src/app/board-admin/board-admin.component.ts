import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service'; 
import { ImageService } from '../_services/image.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  content = '';
  currentUser: any;

  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';
  //imageInfos: Observable<any>;

  constructor(private userService: UserService, private token: TokenStorageService, private imageService: ImageService) { }

  ngOnInit() {
    //this.imageInfos = this.imageService.getListImages();  
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

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
  
  upload(){
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.imageService.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        }
        else if (event instanceof HttpResponse) {
          this.message = event.body.message;
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });
  
    this.selectedFiles = undefined;
  }
}