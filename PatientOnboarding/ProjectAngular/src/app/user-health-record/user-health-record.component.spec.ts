import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHealthRecordComponent } from './user-health-record.component';

describe('UserHealthRecordComponent', () => {
  let component: UserHealthRecordComponent;
  let fixture: ComponentFixture<UserHealthRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHealthRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHealthRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
