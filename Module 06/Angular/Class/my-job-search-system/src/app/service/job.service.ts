import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})


export class JobService {


  

  constructor(private http: HttpClient) { }

    apiEndPoint: string = 'http://localhost:3000/';

  registrationEmployer(obj: any){
   return this.http.post(this.apiEndPoint+'AddNewEmployer',obj); 
  }

  registrationAsJobSeeker(obj: any){
    return this.http.post(this.apiEndPoint+'AddNewJobSeeker',obj); 
   }

   login(obj: any){
    return this.http.post(this.apiEndPoint+'login',obj); 
   }

  }


