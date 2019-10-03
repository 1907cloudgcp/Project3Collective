import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocPatientsComponent } from './doc-patients.component';

describe('DocPatientsComponent', () => {
  let component: DocPatientsComponent;
  let fixture: ComponentFixture<DocPatientsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocPatientsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
