import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobPosting } from '../model/job-posting.model';

@Injectable({
  providedIn: 'root'
})
export class JobPostingService {

  private apiUrl = 'http://localhost:8080/api/job-postings';

  constructor(private http: HttpClient) { }

  getJobPostings(page: number, size: number): Observable<JobPosting[]> {
    const params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this.http.get<JobPosting[]>(this.apiUrl, { params });
  }

  getJobPostingById(id: number): Observable<JobPosting> {
    return this.http.get<JobPosting>(`${this.apiUrl}/${id}`);
  }

  createJobPosting(jobPosting: JobPosting): Observable<JobPosting> {
    return this.http.post<JobPosting>(this.apiUrl, jobPosting);
  }

  updateJobPosting(id: number, jobPosting: JobPosting): Observable<JobPosting> {
    return this.http.put<JobPosting>(`${this.apiUrl}/${id}`, jobPosting);
  }

  deleteJobPosting(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
