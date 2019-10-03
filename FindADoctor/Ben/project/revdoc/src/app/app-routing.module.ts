import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FilterPageComponent } from './filter-page/filter-page.component';
import { DrRatingComponent } from './dr-rating/dr-rating.component';


const routes: Routes = [
{ path: 'filter', component: FilterPageComponent },
{ path: 'table', component: DrRatingComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
