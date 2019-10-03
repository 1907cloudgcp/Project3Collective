import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocHospitalComponent } from './doc-hospital.component';

describe('DocHospitalComponent', () => {
  let component: DocHospitalComponent;
  let fixture: ComponentFixture<DocHospitalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocHospitalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocHospitalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
