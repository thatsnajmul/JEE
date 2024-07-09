import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  baseUrl: string = "http://localhost:3000/locations";

  
  //Create a constractor for manage db.json file from the json server
  constructor(private httpClient: HttpClient) { }

  //For veiwing the db.json data using post
  getAlllocation(location: Location):Observable<any>{
    return this.httpClient.post(this.baseUrl, location);
  }


  //For deleting a row using id
  deleteLocation(id:string):Observable<any>{
    return this.httpClient.delete(this.baseUrl+"/"+"id");
    //  http://localhost:3000/locations/id
  }

}
