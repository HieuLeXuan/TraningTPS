import { Component, OnInit, Input } from '@angular/core';
import { User } from '../model/users';
import { PermissionService } from '../_services/permission.service';
import { Observable } from 'rxjs';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-detail-user-ad',
  templateUrl: './detail-user-ad.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class DetailUserAdComponent implements OnInit {
  @Input() user: User;

  permissions: any;

  constructor(private permissionService: PermissionService, private userService: UserService) { }

  ngOnInit(): void {
    this.permissionService.getListPermissions().subscribe(
      response => {
        // this.permissions = response;
        console.log(response)
      }
    )
  }

  getIdPermissionChecked() {
    console.log(this.permissions)
    this.permissions.forEach(permission => {
      if(permission.checked === true) {
        // return permission.id;
        console.log(permission.id)
      }
    })
  }

  delete(): void {
    this.userService.deleteUser(this.user.id).subscribe(
      response => {
        this.reload();
      }
    );
  }

  reload() {
    window.location.reload();
  }

}
