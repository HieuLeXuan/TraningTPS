import { Component, OnInit, Input } from '@angular/core';
import { User } from '../model/user';
import { PermissionService } from '../_services/permission.service';
import { Observable } from 'rxjs';
import { UserService } from '../_services/user.service';
import { User_Permission } from '../model/user_permission';

@Component({
  selector: 'app-detail-user-ad',
  templateUrl: './detail-user-ad.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class DetailUserAdComponent implements OnInit {
  @Input() user: User;

  permissions: any;

  u_p : User_Permission;

  constructor(private permissionService: PermissionService, private userService: UserService) { }

  ngOnInit(): void {
    this.permissionService.getListPermissions().subscribe(
      response => {
        this.permissions = response;
        // console.log(this.permissions)s
      }
    );
  }

  getIdPermissionChecked(): number {
    this.permissions.forEach(permission => {
      if (permission.checked === true) {
        return permission.id;
        // console.log(permission.id)
      }
    });
    return 1;
  }

save() : void {
  this.permissionService.setPermissions(this.u_p, this.user.id, this.getIdPermissionChecked()).subscribe(
    response =>{
      console.log("ok");
    }
  );
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
