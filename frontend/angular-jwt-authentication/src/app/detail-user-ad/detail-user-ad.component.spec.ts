import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailUserAdComponent } from './detail-user-ad.component';

describe('DetailUserAdComponent', () => {
  let component: DetailUserAdComponent;
  let fixture: ComponentFixture<DetailUserAdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailUserAdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailUserAdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
