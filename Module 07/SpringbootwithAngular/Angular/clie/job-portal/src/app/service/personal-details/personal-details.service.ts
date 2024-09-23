import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonalDetails } from '../../model/personal-details-model';

@Injectable({
  providedIn: 'root'
})
export class PersonalDetailsService {

  private apiUrl = 'http://localhost:8080/api/personal-details'; // Update with your API URL

  constructor(private http: HttpClient) { }

  // Get all personal details
  getAllPersonalDetails(): Observable<PersonalDetails[]> {
    return this.http.get<PersonalDetails[]>(this.apiUrl);
  }

  // Get personal details by ID
  getPersonalDetailsById(id: number): Observable<PersonalDetails> {
    return this.http.get<PersonalDetails>(`${this.apiUrl}/${id}`);
  }

  // Service method to update personal details
updatePersonalDetails(id: number, personalDetails: PersonalDetails): Observable<PersonalDetails> {
  return this.http.put<PersonalDetails>(`/api/personal-details/${id}`, personalDetails);
}

// Service method to create personal details
createPersonalDetails(personalDetails: PersonalDetails): Observable<PersonalDetails> {
  return this.http.post<PersonalDetails>('/api/personal-details', personalDetails);
}


  // Delete personal details by ID
  deletePersonalDetails(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
