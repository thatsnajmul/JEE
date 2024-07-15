import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})


export class JobService {


  

  constructor(private http: HttpClient) { }

    apiEndPoint: string = 'https://freeapi.miniprojectideas.com/api/JobPortal/';

  registrationEmployer(obj: any){
   return this.http.post(this.apiEndPoint+'AddNewEmployer',obj);
    
  }

  
  
  }


