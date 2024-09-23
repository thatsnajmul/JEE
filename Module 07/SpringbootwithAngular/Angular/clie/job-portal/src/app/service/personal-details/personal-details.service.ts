import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonalDetails } from '../../model/personal-details-model';

@Injectable({
  providedIn: 'root'
})
export class PersonalDetailsService {

  private apiUrl = 'http://localhost:8080/api/personal-details';

    constructor(private http: HttpClient) {}

    createPersonalDetails(details: PersonalDetails): Observable<PersonalDetails> {
        return this.http.post<PersonalDetails>(this.apiUrl, details);
    }

    updatePersonalDetails(id: number, details: PersonalDetails): Observable<PersonalDetails> {
        return this.http.put<PersonalDetails>(`${this.apiUrl}/${id}`, details);
    }

    getPersonalDetails(id: number): Observable<PersonalDetails> {
        return this.http.get<PersonalDetails>(`${this.apiUrl}/${id}`);
    }

    deletePersonalDetails(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }

    getAllPersonalDetails(): Observable<PersonalDetails[]> {
        return this.http.get<PersonalDetails[]>(this.apiUrl);
    }

    
}
