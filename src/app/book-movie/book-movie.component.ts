import { Component, OnInit } from '@angular/core';
import { BookingMovie } from '../book-movie.model';
//import { BookMovieService } from './book-movie.service';
//import { BookingMovie } from './book-movie.model';

@Component({
  selector: 'app-booking-movie',
  templateUrl: './book-movie.component.html',
  styleUrls: ['./book-movie.component.css']
})
export class BookingMovieComponent implements OnInit {
  newBooking: any = {};
  booking: BookingMovie = new BookingMovie();
  customerId: string="";
  screenId: string="";
  noOfTickets: number=0;
  amount: number=0;
  bookingId: string="";
  bookingDate: string="";
  theatreId: string="";
  bookMovieService: any;

  //constructor(private bookMovieService: BookMovieService) {}

  ngOnInit() {
    this.viewAll();
    this.getTotalAmountMoviewise();
  }

  addBooking() {
    this.bookMovieService.addBooking(this.booking, this.customerId, this.screenId)
      .subscribe(
        (        response: any) => {
          // Handle success response
          console.log('Booking added successfully', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error adding booking', error);
        }
      );
  }

  updateTicketAndAmount() {
    this.bookMovieService.updateTicketAndAmount(this.noOfTickets, this.amount)
      .subscribe(
        (        response: any) => {
          // Handle success response
          console.log('Booking updated successfully', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error updating booking', error);
        }
      );
  }

  deleteBooking() {
    this.bookMovieService.deleteBooking(this.bookingId)
      .subscribe(
        (        response: any) => {
          // Handle success response
          console.log('Booking deleted successfully', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error deleting booking', error);
        }
      );
  }

  viewAll() {
    this.bookMovieService.viewAll()
      .subscribe(
        (        response: any) => {
          // Handle success response (e.g., populate a table)
          console.log('View all bookings', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error viewing all bookings', error);
        }
      );
  }

  viewBookingById() {
    this.bookMovieService.viewBookingById(this.bookingId)
      .subscribe(
        (        response: any) => {
          // Handle success response
          console.log('View booking by ID', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error viewing booking by ID', error);
        }
      );
  }

  viewBookingByBookingDate() {
    this.bookMovieService.viewBookingByBookingDate(this.bookingDate)
      .subscribe(
        (        response: any) => {
          // Handle success response
          console.log('View booking by booking date', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error viewing booking by booking date', error);
        }
      );
  }

  viewBookingByTheatreId() {
    this.bookMovieService.viewBookingByTheatreId(this.theatreId)
      .subscribe(
        (        response: any) => {
          // Handle success response
          console.log('View booking by theatre ID', response);
        },
        (        error: any) => {
          // Handle error response
          console.error('Error viewing booking by theatre ID', error);
        }
      );
  }

  getTotalAmountMoviewise() {
    this.bookMovieService.getTotalAmountMoviewise()
      .subscribe(
        (        response: any) => {
          // Handle success response (e.g., populate a table)
          console.log('Get total amount moviewise', response);
        },
        (        error: any)=> {
          // Handle error response
          console.error('Error getting total amount moviewise', error);
        }
      );
  }
}
