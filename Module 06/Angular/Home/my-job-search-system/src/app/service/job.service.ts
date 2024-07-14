import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
//import { Observable } from 'rxjs';

interface EmployeerData {
  CompanyName: string;
  EmailId: string;
  MobileNo: string;
  PhoneNo: string;
  CompanyAddress: string;
  City: string;
  State: string;
  PinCode: string;
  LogoURL: string;
  GstNo: string;
}

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


