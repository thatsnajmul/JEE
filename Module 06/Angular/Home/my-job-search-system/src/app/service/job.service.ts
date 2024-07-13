import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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


  private apiUrl = 'http://localhost:3000/AddNewEmployer';

  constructor(private http: HttpClient) { }

  registrationEmployer(employee: EmployeerData): Observable<EmployeerData> {
    return this.http.post<EmployeerData>(this.apiUrl, employee);
  }

  // //apiEndPoint: string = 'https://freeapi.miniprojectideas.com/api/JobPortal/'
  // baseUrl: string = "http://localhost:3000/AddNewEmployer";

  // constructor(private http: HttpClient) { 
    
  // }

  // registrationEmployer(obj: any){
  //   //return this.http.post(this.apiEndPoint+'AddNewEmployer',obj);
  //   //return this.httpClient.get(this.baseUrl);
  //   return this.http.post(this.baseUrl,obj);
  // }

  
  
  }


