import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailImgAdComponent } from './detail-img-ad.component';

describe('DetailImgAdComponent', () => {
  let component: DetailImgAdComponent;
  let fixture: ComponentFixture<DetailImgAdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailImgAdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailImgAdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
