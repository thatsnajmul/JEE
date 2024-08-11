import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private apiUrl = 'http://localhost:3000/jobs';

  constructor(private http: HttpClient) {}

  getJobs() {
    return this.http.get<any[]>(this.apiUrl);
  }

  addJob(job: any) {
    return this.http.post(this.apiUrl, job);
  }
}
