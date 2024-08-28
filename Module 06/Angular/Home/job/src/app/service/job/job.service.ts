// job.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../../model/job.model';
import {Application} from "../../model/applications.model";

@Injectable({
  providedIn: 'root',
})
export class JobService {
  private apiUrl = 'http://localhost:3000/jobs';

  private dbj = 'http://localhost:300';

  private apiUrl1 = 'http://localhost:3000/applications';

  constructor(private http: HttpClient) { }


  //////////
  getJobs(): Observable<any> {
    return this.http.get<any>(this.dbj);
  }
  //////////////


  //Job Application
  //Create
  submitApplication(application: any): Observable<any> {
    return this.http.post<any>(this.apiUrl1, application);
  }
  //View
  getAllJobApplications(): Observable<Application[]> {
    return this.http.get<Application[]>(this.apiUrl1);
  }



  // View Jobs in job page
  getAllJobs(): Observable<Job[]> {
    return this.http.get<Job[]>(this.apiUrl);
  }

  //Create a new job
  createJob(job: Job): Observable<Job> {
    return this.http.post<Job>(this.apiUrl, job);
  }

  //
    //
      //

  updateJob(job?: Job): Observable<Job> {
    return this.http.put<Job>(`${this.apiUrl}/${job?.id}`, job);
  }

  deleteJob(jobId?: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${jobId}`);
    //return this.http.delete<void>(this.baseUrl+jobId);
  }

  getJobById(jobId: string): Observable<Job> {
    // const url = `${this.baseUrl}/${jobId}`;
    return this.http.get<Job>(`${this.apiUrl}/${jobId}`);
  }


}
