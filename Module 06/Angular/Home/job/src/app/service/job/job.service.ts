// job.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../../model/job.model';
import {Application} from "../../model/applications.model";
import { cvData } from '../../model/cvData.model';
@Injectable({
  providedIn: 'root',
})
export class JobService {
  private apiUrl = 'http://localhost:3000/jobs';
  private dbj = 'http://localhost:300';
  private application = 'http://localhost:3000/applications';
  private cvData = 'http://localhost:3000/cvData';

  
  constructor(private http: HttpClient) { }
  getJobs(): Observable<any> {
    return this.http.get<any>(this.dbj);
  }
  getAllJobApplications(): Observable<Application[]> {
    return this.http.get<Application[]>(this.application);
  }
  getAllJobs(): Observable<Job[]> {
    return this.http.get<Job[]>(this.apiUrl);
  }
  getJobById(jobId: string): Observable<Job> {
    // const url = `${this.baseUrl}/${jobId}`;
    return this.http.get<Job>(`${this.apiUrl}/${jobId}`);
  }
  submitApplication(application: any): Observable<any> {
    return this.http.post<any>(this.application, application);
  }
  //
  submitCvData(cvData: any): Observable<any> {
    return this.http.post<any>(this.cvData, cvData);
  }
  getAllCvData(): Observable<cvData[]> {
    return this.http.get<cvData[]>(this.cvData);
  }




  createJob(job: Job): Observable<Job> {
    return this.http.post<Job>(this.apiUrl, job);
  }
  
  updateJob(job?: Job): Observable<Job> {
    return this.http.put<Job>(`${this.apiUrl}/${job?.id}`, job);
  }
  deleteJob(jobId?: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${jobId}`);
    //return this.http.delete<void>(this.baseUrl+jobId);
  }
}
