import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { PreLoginComponent } from './pre-login/pre-login.component';
import { HttpClientModule } from '@angular/common/http';
import { UserHomeComponent } from './user-home/user-home.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { HospitalsComponent } from './hospitals/hospitals.component';
import { RouterModule } from '@angular/router';
import { HospitalInfoComponent } from './hospital-info/hospital-info.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserService } from './user/user.service';
import { PatientsComponent } from './patients/patients.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { TransferService } from './transfer/transfer.service';
import { User } from './user';
import { UserHealthRecordComponent } from './user-health-record/user-health-record.component';
import { HealthRecord } from './user-health-record/healthrecord';
import { DocPatientsComponent } from './doc-patients/doc-patients.component';
import { DocHospitalComponent } from './doc-hospital/doc-hospital.component';
import { Frequency } from './frequency';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    PreLoginComponent,
    UserHomeComponent,
    PatientInfoComponent,
    HospitalsComponent,
    HospitalInfoComponent,
    NavbarComponent,
    PatientsComponent,
    UserInfoComponent,
    UserHealthRecordComponent,
    DocPatientsComponent,
    DocHospitalComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'app-pre-login', component: PreLoginComponent},
      {path: 'app-user-home', component: UserHomeComponent},
      {path: 'app-doc-patients', component: DocPatientsComponent},
      {path: 'app-doc-hospital', component: DocHospitalComponent},
      {path: 'app-patients', component: PatientsComponent},
      {path: 'app-hospitals', component: HospitalsComponent},
      {path: 'app-hospital-info/:id', component: HospitalInfoComponent},
      {path: 'app-user-info', component: UserInfoComponent},
      {path: 'app-user-health-record', component: UserHealthRecordComponent},
      {path: 'app-patient-info/:userId', component: PatientInfoComponent},
      {path: '**', redirectTo: 'app-pre-login', pathMatch: 'full'}
    ])
  ],
  providers: [UserService, PatientsComponent, UserInfoComponent, TransferService, User, HealthRecord, Frequency],
  bootstrap: [AppComponent]
})
export class AppModule { }
