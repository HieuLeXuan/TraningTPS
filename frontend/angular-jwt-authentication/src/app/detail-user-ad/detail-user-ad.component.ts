import { Component, OnInit, Input } from '@angular/core';
import { User } from '../model/users';

@Component({
  selector: 'app-detail-user-ad',
  templateUrl: './detail-user-ad.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class DetailUserAdComponent implements OnInit {
  @Input() user: User;

  constructor() { }

  ngOnInit(): void {
  }

}
