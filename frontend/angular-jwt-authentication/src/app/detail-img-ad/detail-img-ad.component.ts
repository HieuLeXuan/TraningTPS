import { Component, OnInit, Input } from '@angular/core';
import { Image }  from '../model/image';
import { ImageService } from '../_services/image.service';

@Component({
  selector: 'app-detail-img-ad',
  templateUrl: './detail-img-ad.component.html',
  styleUrls: ['../../assets/css/styles.css']
})
export class DetailImgAdComponent implements OnInit {
  @Input() image2: Image;
  @Input() image3: Image;

  constructor(private imageService: ImageService) { }

  ngOnInit(): void {
  }

  save(): void {
    this.imageService.updateImage(this.image2, this.image2.id).subscribe(
      respones => {
        this.reload();
      }
    );
  }

  delete(): void {
    this.imageService.deleteImage(this.image2.id).subscribe(
      respones => {
        this.reload();
      }
    );
  }

  reload() {
    window.location.reload();
  }

}
