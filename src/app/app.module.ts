import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingMovie } from './book-movie.model';
import { MovieComponent } from './movie/movie.component';
import { TheatreComponent } from './theatre/theatre.component';
import { ScreeningComponent } from './screening/screening.component';
import { CustomerComponent } from './customer/customer.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MovieService } from './movie.service';
import { TheatreService } from './theatre.service';
//import { TheatreService } from './theatre/theatre.service';



//import { BookMovie } from './book-movie/book-movie.component';
//import { AppComponent } from './app.component';
//import { BookMovieComponent } from './book-movie/book-movie.component';
//import { BookingMovieComponent } from './book-movie/booking-movie.component';
//import { BookingMovie } from './booking-movie/booking-movie.model';

 

@NgModule({
  declarations: [
    AppComponent,
    MovieComponent,
    TheatreComponent,
    ScreeningComponent,
    CustomerComponent
    
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule
    
  ],
  providers: [MovieService,TheatreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
