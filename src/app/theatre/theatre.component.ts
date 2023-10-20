import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { TheatreService } from '../theatre.service';
import { Router, ActivatedRoute } from '@angular/router';
import { theatre } from './theatre';

@Component({
  selector: 'app-theatre',
  templateUrl: './theatre.component.html',
  styleUrls: ['./theatre.component.css']
})
export class TheatreComponent implements OnInit {
  theatres: theatre[] = [];
  message: string = '';
  errorMessage: string = '';
  viewCityTicketErrorMessage: any;
  viewCityTicketMessage: string | undefined;
  viewCityTicketResults: any;
  newTheatre: any = {}; 
  updateTheatreId: string = '';
  viewTheatreId: string; // Property to store the ID for viewing by ID
  viewCity: string; // Property to store the city for viewing by city and ticket cost
  updatedTicketCost: number; // Property to store the ticket cost for viewing by city and ticket cost
  viewTheatreMessage: string; // Property to store success message
  viewTheatreErrorMessage: string; // Property to store error message
  viewTheatreResults: any[] = [];
  method: string = ''; // Property to store the selected method
  router: any;
  viewdata: any[] = [];
  viewTicketCost: number;
  // setMethod(selectedMethod: string) {
  //   this.method = selectedMethod;
  // }
  

setMethod(selectedMethod: string) {
  // Use the Router to navigate to the specified route
  this.router.navigate(['theatre', selectedMethod]);
}
  constructor(private theatreService: TheatreService,private route: ActivatedRoute) {
    // Initialize properties here if needed
  //  private router: Router, 
  //  private route: ActivatedRoute | undefined
    this.viewTheatreId = '';
    this.viewCity = '';
    this.updatedTicketCost = 0;
    this.viewTheatreMessage = '';
    this.viewTheatreErrorMessage = '';
    this.viewTicketCost=0;
  }

  ngOnInit(): void {
    this.viewAllTheatres();
    this.route.queryParams.subscribe(params => {
      this.method = params['method'] || ''; 
    });
  }
 
  addTheatre(newTheatre: any) {
    
    console.log(JSON.stringify(newTheatre));
    this.theatreService.addTheatre(newTheatre).subscribe(
      (response: any) => {
        console.log("added");
        this.message = `Theatre with id ${response.theatreId} added successfully.`;
        //this.viewAllTheatres();
       //this.method = ''; // Clear the selected method after completion
      },
      (error: any) => {
        // this.errorMessage = error.error;
        this.errorMessage = `Not able to add theatre, please enter accurate data!`;
      }
    );
  }

  updateTicketCost(theatreId: string, ticketCost: number) {
    this.theatreService.updateTicketCost(theatreId, ticketCost).subscribe(
      (response: any) => {
        console.log("updated");
        if(response){
        this.message = `Theatre Id ${response.theatreId} ticket cost updated successfully as ${response.ticketCost}!.`;
        this.viewAllTheatres();
        }else{
          this.errorMessage = 'please enter valid Theatre Id or Ticket cost!';

        }
        //this.method = ''; // Clear the selected method after completion
      },
      (error: any) => {
        this.errorMessage = 'please enter valid Theatre Id or Ticket cost!';
      }
    );
  }

  viewAllTheatres() {
    this.theatreService.viewAll().subscribe(
      (response: any) => {
        this.theatres = JSON.parse(response);
        console.log(JSON.stringify(this.theatres));
        //this.message = 'View all for Theatre done successfully.';
       // this.method = ''; 
        //this.viewdata = JSON.parse(response);
        //console.log(this.viewdata);
    
      },
      (error: any) => {
        this.errorMessage = error.error;
      }
    );
  }

  th:theatre= new theatre();
  viewTheatreByID(theatreId: string) {
   this.clearMessages();

    this.theatreService.viewTheatreByID(theatreId).subscribe(
      (response: any) => {
        if (response) {
          this.th=JSON.parse(response);
          //this.theatres = JSON.parse(response);

          this.message = `Theatre Id ${response.theatreId} details retrieved successfully.`;
        } else {
          this.errorMessage = `Theatre with this ID ${response.theatreId} not found.`;
        }
        //this.method = ''; // Clear the selected method after completion
      },
      (error: any) => {
        // this.errorMessage = error.error;
        this.errorMessage = `Theatre with this ID ${theatreId} not found.`;

      }
    );
  }

  th1:theatre[]= [];
  viewTheatreByCityAndTicketCost(city: string, ticketCost: number) {
    this.theatreService.viewTheatreByCityAndTicketCost(city, ticketCost).subscribe(
      (response: any) => {
        if (response && response.length > 0) {
         this.th1 = JSON.parse(response);
         //this.th=response;
          console.log(JSON.stringify(this.th));

          this.viewCityTicketMessage = 'Theatre details retrieved successfully.';
        } else {
          this.viewCityTicketErrorMessage = 'No theatres found for the given criteria.';
        }
       // this.method = ''; // Clear the selected method after completion
      },
      (error: any) => {
        // this.viewCityTicketErrorMessage = error.error;
        this.viewCityTicketErrorMessage = 'No theatres found for the given criteria.';

      }
    );
  }

  clearMessages() {
    this.message = '';
    this.errorMessage = '';
    this.viewCityTicketMessage = '';
    this.viewCityTicketErrorMessage = '';
  }
}
