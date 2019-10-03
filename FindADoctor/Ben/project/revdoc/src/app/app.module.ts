import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { DrRatingComponent } from './dr-rating/dr-rating.component';
import { Pg3Component } from './pg3/pg3.component';
import { Page1Component } from './page1/page1.component';
import { HttpClientModule } from '@angular/common/http';
import { StarComponent } from './star/star.component';
import { FilterPageComponent } from './filter-page/filter-page.component';
import { DoctorService } from './DoctorService/doctor.service';
import { FilterServiceService } from './FilterService/filter.service';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SetValuesService } from './setValues/set-values.service';
import { ProfileComponent } from './profile/profile.component';
import { CalanderComponent } from './calander/calander.component';
import { FullCalendarModule } from '@fullcalendar/angular'; // for FullCalendar!


@NgModule({
  declarations: [
    AppComponent,
    DrRatingComponent, Pg3Component, Page1Component, StarComponent, FilterPageComponent, LoginComponent, ProfileComponent, CalanderComponent
  ],
  imports: [
    BrowserModule, FormsModule, BrowserModule, HttpClientModule, AppRoutingModule, FullCalendarModule, // for FullCalendar!
    RouterModule.forRoot([
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'filter', component: FilterPageComponent },
    { path: 'calander/:docname', component: CalanderComponent },
    { path: 'profile/:docname', component: ProfileComponent },
    { path: 'table', component: DrRatingComponent }])
  ],
  exports: [],
  providers: [DoctorService, FilterServiceService, SetValuesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
