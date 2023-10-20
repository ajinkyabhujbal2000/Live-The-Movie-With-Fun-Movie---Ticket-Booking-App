
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MovieComponent } from './movie/movie.component';
import { TheatreComponent } from './theatre/theatre.component';
import { ScreeningComponent } from './screening/screening.component';
import { CustomerComponent } from './customer/customer.component';
import { BookingMovieComponent } from './book-movie/book-movie.component';
import { Router, ActivatedRoute } from '@angular/router';


const routes: Routes = [
  { path: 'movie', component: MovieComponent },
  { path: 'theatre', component: TheatreComponent },
  { path: 'screen', component: ScreeningComponent },
  { path: 'customer', component: CustomerComponent },
  { path: 'bookmovie', component: BookingMovieComponent },
  //{ path: '', redirectTo: 'movie', pathMatch: 'full' }, // Default route,
  {
    path: 'theatre/add', // Route for adding a theatre
    component: TheatreComponent,
    data: { method: 'addTheatre' },
  },
  {
    path: 'theatre/update', // Route for updating ticket cost
    component: TheatreComponent,
    data: { method: 'updateTicketCost' },
  },
  {
    path: 'theatre/viewAll', // Route for viewing all theatres
    component: TheatreComponent,
    data: { method: 'viewAll' },
  },
  {
    path: 'theatre/view-by-id', // Route for viewing theatre by ID
    component: TheatreComponent,
    data: { method: 'viewTheatreByID' },
  },
  {
    path: 'theatre/view-by-city', // Route for viewing theatre by City and Ticket Cost
    component: TheatreComponent,
    data: { method: 'viewTheatreByCityAndTicketCost' },
  },
  {
    path: 'movie/:method',
    component: MovieComponent
  },

  {
    path: 'movie/add',
    component: MovieComponent,
    data: { method: 'add' },
  },
  {
    path: 'movie/update',
    component: MovieComponent,
    data: { method: 'updateDuration' },
  },
  {
    path: 'movie/viewAll',
    component: MovieComponent,
    data: { method: 'viewAll' },
  },
  {
    path: 'movie/view-by-id',
    component: MovieComponent,
    data: { method: 'viewMovieByID' },
  },
  {
    path: 'movie/view-by-director-and-certification',
    component: MovieComponent,
    data: { method: 'viewMovieByDirectorNameAndCertification' },
  },
  {
    path: 'movie/count-director',
    component: MovieComponent,
    data: { method: 'getMovieCountDirectorWise' },
  },
  {
    path: 'movie/view-by-theatre',
    component: MovieComponent,
    data: { method: 'viewMovieByTheatre' },
  },
  {
    path: 'movie/max-booking',
    component: MovieComponent,
    data: { method: 'viewMovieWithMaxBooking' },
  },
  // Add more routes for other methods within TheatreComponent
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
