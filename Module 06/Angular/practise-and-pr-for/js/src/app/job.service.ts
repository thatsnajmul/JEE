import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor() { }

  private apiUrl = 'http://localhost:3000/jobs';

  getJobs() {
    return this.http.get(this.apiUrl);
  }

  postJob(job: any) {
    return this.http.post(this.apiUrl, job);
  }
}
