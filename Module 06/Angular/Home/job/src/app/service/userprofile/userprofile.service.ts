import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '../../service/auth/auth.service';
import { UserModel } from '../../model/user.model';
import { Observable, of } from 'rxjs';
import { PersonalDetails } from '../../model/personalDetails.model';

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  private baseUrl = 'http://localhost:3000/user';
  private education = 'http://localhost:3000/education'
  private experience = 'http://localhost:3000/experience'
  private skill = 'http://localhost:3000/skill'
  private language = 'http://localhost:3000/language'
  private personalDetails = 'http://localhost:3000/personaldetails'

  constructor(private http: HttpClient, private authService: AuthService) { }

  getUserProfile(): Observable<UserModel | null> {
    return of(this.authService.getUserProfileFromStorage());
  }

  updateUserProfile(user: UserModel): Observable<UserModel> {
    localStorage.setItem('userProfile', JSON.stringify(user));
    return this.http.put<UserModel>(`${this.baseUrl}/${user.id}`, user);
  }

  submitpersonalDetails(personaldetails: any): Observable<any> {
    return this.http.post<any>(this.personalDetails, personaldetails);
  }

  
  getPersonalDetails(): Observable<PersonalDetails[]> {
    return this.http.get<PersonalDetails[]>(this.personalDetails);
  }

  
}
