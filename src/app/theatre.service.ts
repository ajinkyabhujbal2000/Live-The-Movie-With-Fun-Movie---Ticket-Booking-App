import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class TheatreService {

  //  public baseUrl = 'http://localhost:8083/theatre';

  constructor(private base: BaseService) { }

  addTheatre(data: any) {
    return this.base.post('theatre/addTheatre', data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  viewAll() {
    return this.base.get('theatre/viewAll').pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  updateTicketCost(theatreId: any,ticketCost: any) {
    return this.base.put(`theatre/updateTicketCost/${theatreId}/${ticketCost}`).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  
  viewTheatreByID(theatreId: any) {
    return this.base.get(`theatre/viewTheatreById/${theatreId}`).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  viewTheatreByCityAndTicketCost(city: any,ticketCost: any) {
    return this.base.get(`theatre/viewTheatresByCityAndTicketCost/${city}/${ticketCost}`).pipe(
      map((res: any) => {
        return res;
      })
    );
  }
}
