import { Injectable } from '@angular/core';

import { map } from 'rxjs';

import { BaseService } from './base.service';

 

@Injectable({

  providedIn: 'root'

})

export class MovieService {

 


 

  constructor(private base: BaseService) { }

 

  addMovie(data: any) {

    return this.base.post('movie/addMovie', data).pipe(

      map((res: any) => {

        return res;

      })

    );

  }

 

  updateDuration(movieId: any,newDuration: any) {

    return this.base.put(`movie/updateDuration/${movieId}/${newDuration}`).pipe(

      map((res: any) => {

        return res;

      })

    );

  }

 

  viewAll() {

    return this.base.get('movie/viewAll').pipe(

      map((res: any) => {

        return res;

      })

    );

  }

 

  viewMovieByID(movieId: any) {

    return this.base.get(`movie/viewMovieByID/${movieId}`).pipe(

      map((res: any) => {

        return res;

      })

    );

  }

 

  viewMovieByDirectorNameAndCertification(directorName: any,certification: any) {

    return this.base.get(`movie/viewMovieByDirectorNameAndCertification/${directorName}/${certification}`).pipe(

      map((res: any) => {

        return res;

      })

    );

  }

 

  getMovieCountDirectorWise() {

    return this.base.get(`movie/getMovieCountDirectorWise}`).pipe(

      map((res: any) => {

        return res;

      })

    );

  }

}