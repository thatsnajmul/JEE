import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonalDetails } from '../../model/personal-details-model'; // create a PersonalDetails model based on your entity

@Injectable({
    providedIn: 'root'
})
export class PersonalDetailsService {
    private apiUrl = 'http://localhost:8080/api/personal-details'; // Update with your API URL

    constructor(private http: HttpClient) { }

    getAllPersonalDetails(): Observable<PersonalDetails[]> {
        return this.http.get<PersonalDetails[]>(this.apiUrl);
    }

    getPersonalDetailsById(id: number): Observable<PersonalDetails> {
        return this.http.get<PersonalDetails>(`${this.apiUrl}/${id}`);
    }

    createPersonalDetails(personalDetails: PersonalDetails): Observable<PersonalDetails> {
        return this.http.post<PersonalDetails>(this.apiUrl, personalDetails);
    }

    getPersonalDetails(): Observable<any[]> {
      return this.http.get<any[]>(`${this.apiUrl}`);
  }

  updatePersonalDetails(id: number, details: any): Observable<any> {
      return this.http.put(`${this.apiUrl}/${id}`, details);
  }

  deletePersonalDetails(id: number): Observable<any> {
      return this.http.delete(`${this.apiUrl}/${id}`);
  }
}

