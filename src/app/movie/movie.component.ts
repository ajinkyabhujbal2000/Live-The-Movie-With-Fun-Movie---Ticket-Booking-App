import { Component, OnInit } from '@angular/core';

import { MovieService } from '../movie.service';

import { Router, ActivatedRoute } from '@angular/router';
import { movie } from './movie';

 

 

@Component({

  selector: 'app-movie',

  templateUrl: './movie.component.html',

  styleUrls: ['./movie.component.css']

})

export class MovieComponent implements OnInit {

  [x: string]: any;

  movies: movie[] = [];
  
  movieId: string;

  newDuration: number;

  


  successMessage: string;

  errorMessage: string;

  directorName: string;

  certification: string;

  theatreId: string;

  method: string = ''; // Property to store the selected method

  router: any;

 

  movieName: string = '';

  duration: number = 0;

  language: string;

  movieRating: string;

 

 

 

  constructor(private movieService: MovieService,private route: ActivatedRoute) {

    this.movieId='';

    this.newDuration=0;

    this.movies=[];

    this.successMessage='';

    this.errorMessage='';

    this.directorName='';

    this.certification='';

    this.theatreId='';

    this.language='';

    this.movieRating='';

    this.newDuration=0;

 

   

 

    this.route.queryParams.subscribe(params => {

      this.method = params['method'] || 'view-all'; // Default to 'view-all' if no method is provided

    });

   }

 

  ngOnInit() {

   

   // this.viewAll();

    //this.viewMovieWithMaxBooking();

    this['route'].queryParams.subscribe((params: { [x: string]: string; }) => {

      this.method = params['method'] || '';

      this.movieId = params['movieId'];

    });

   

  }

 

  addMovie() {

    const movie = {

      movieId: this.movieId,

      movieName:this.movieName,

      duration: this.duration,

      language: this.language,

      movieRating: this.movieRating,

      directorName: this.directorName,

      certification: this.certification

      // Include other movie details here

    };

    console.log(JSON.stringify(movie));

 

    this.movieService.addMovie(movie).subscribe(

      (response) => {

        this.successMessage = `Movie with id ${this.movieId} added  successfully`;

        this.errorMessage = '';

      },

      (error) => {

        this.successMessage = '';

        this.errorMessage = error.message;

      }

    );

  }

 

  updateDuration() {

    this.movieService.updateDuration(this.movieId, this.newDuration).subscribe(

      (response) => {

        this.successMessage = `Movie ID ${this.movieId} duration updated successfully as ${this.newDuration}`;

        this.errorMessage = '';

      },

      (error) => {

        this.successMessage = '';

        this.errorMessage = `Movie ID ${this.movieId} does not exist`;

      }

    );

  }

 

  viewAll() {

    this.movieService.viewAll().subscribe(

      (response: any) => {
        //this.movies = response;
        this.movies = JSON.parse(response);
        console.log(JSON.stringify(this.movies));
        this.successMessage = 'View all for Movie done successfully';

        this.errorMessage = '';
        //this.method='';
       },

      (error:any) => {
        this.errorMessage = error.message;
      }

    );

  }

 
  // th:theatre= new theatre();
  mo:movie=new movie();
  viewMovieByID() {

    this.movieService.viewMovieByID(this.movieId).subscribe(

      (data: any) => {

        this.mo =JSON.parse(data);

        this.successMessage = `Movie Id ${this.movieId} details retrieved successfully`;

        this.errorMessage = '';

      },

      (error) => {

        this.errorMessage = `Movie Id ${this.movieId} does not exist`;

        this.successMessage = '';

      }

    );

  }

 

  // viewMovieByDirectorNameAndCertification() {

  //   this.movieService.viewMovieByDirectorNameAndCertification(this.directorName, this.certification).subscribe(

  //     (data: any) => {

  //       this.movies = data;

  //       this.successMessage = 'View Movie By Director Name and Certification done successfully';

  //       this.errorMessage = '';

  //     },

  //     (error) => {

  //       this.errorMessage = error.message;

  //       this.successMessage = '';

  //     }

  //   );

  // }
  mo1:movie[]= [];
  viewMovieByDirectorNameAndCertification() {

    this.movieService.viewMovieByDirectorNameAndCertification(this.directorName, this.certification).subscribe(

      (data: any) => {

        this.mo1 = JSON.parse(data);

        this.successMessage = 'View Movie By Director Name and Certification done successfully';

        this.errorMessage = '';

      },

      (error) => {

        this.errorMessage = error.message;

        this.successMessage = '';

      }

    );

  }

 

 

  getMovieCountDirectorWise() {

    this.movieService.getMovieCountDirectorWise().subscribe(

      (data: any) => {

        this.movies = data;

        console.log(data);

        this.successMessage = 'Get Movie Count Director Wise done successfully';

        this.errorMessage = '';

      },

      (error) => {

        this.errorMessage = error.message;

        this.successMessage = '';

      }

    );

  }

 

  // viewMovieByTheatre() {

  //   this.movieService.viewMovieByTheatre(this.theatreId).subscribe(

  //     (data: any) => {

  //       this.movies = data;

  //       this.successMessage = 'View Movie by Theatre done successfully';

  //       this.errorMessage = '';

  //     },

  //     (error) => {

  //       this.errorMessage = error.message;

  //       this.successMessage = '';

  //     }

  //   );

  // }

 

  // viewMovieWithMaxBooking() {

  //   this.movieService.viewMovieWithMaxBooking().subscribe(

  //     (data: any) => {

  //       this.movies = data;

  //       this.successMessage = 'View Movie with Maximum Booking done successfully';

  //       this.errorMessage = '';

  //     },

  //     (error) => {

  //       this.errorMessage = error.message;

  //       this.successMessage = '';

  //     }

  //   );

  // }

}