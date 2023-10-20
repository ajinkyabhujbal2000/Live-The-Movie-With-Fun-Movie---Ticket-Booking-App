import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class BaseService {
  userData: any;
   public baseUrl = 'http://localhost:8083/';


  constructor(private http: HttpClient) {}

  get(url: string, data?: any) {
    return this.http.get(this.baseUrl + url, { responseType: 'text' });
  }


 
  

  post(url: string, data: any) {
    return this.http.post(this.baseUrl + url, data);
  }


  put(url: string, data?: any) {

    return this.http.put(this.baseUrl + url, data);
  }
  

 



}
