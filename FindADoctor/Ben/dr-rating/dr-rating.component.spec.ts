import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrRatingComponent } from './dr-rating.component';

describe('DrRatingComponent', () => {
  let component: DrRatingComponent;
  let fixture: ComponentFixture<DrRatingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrRatingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrRatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
