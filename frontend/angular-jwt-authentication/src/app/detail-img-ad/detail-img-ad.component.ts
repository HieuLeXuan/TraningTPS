import { Component, OnInit, Input } from '@angular/core';
import { Image }  from '../model/image';

@Component({
  selector: 'app-detail-img-ad',
  templateUrl: './detail-img-ad.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class DetailImgAdComponent implements OnInit {
  @Input() image2: Image;

  constructor() { }

  ngOnInit(): void {
  }

}
