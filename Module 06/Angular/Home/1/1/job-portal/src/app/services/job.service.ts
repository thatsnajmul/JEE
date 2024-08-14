import { Injectable } from '@angular/core';
import { Job } from '../model/job.model';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private jobs: Job[] = [];
  private jobIdCounter = 1;

  getJobs(): Job[] {
    return this.jobs;
  }

  postJob(job: Job): void {
    job.id = this.jobIdCounter++;
    this.jobs.push(job);
  }

  getJobById(id: number): Job | undefined {
    return this.jobs.find(job => job.id === id);
  }
}

