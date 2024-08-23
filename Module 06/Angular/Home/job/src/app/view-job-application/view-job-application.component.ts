import {Component, OnInit} from '@angular/core';
import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';
import {Application} from "../model/applications.model";

@Component({
  selector: 'app-view-job-application',
  templateUrl: './view-job-application.component.html',
  styleUrl: './view-job-application.component.css'
})
export class ViewJobApplicationComponent implements OnInit{
  applications: Application[] = [];

  constructor(private jobService: JobService) {}

  ngOnInit(): void {
    this.getJobApplications();
  }

  getJobApplications(): void {
    this.jobService.getAllJobApplications().subscribe(
      (data: Application[]) => {
        this.applications = data;
      },
      (error: any) => { // Using 'any' type
        console.error('There was an error fetching the jobs!', error);
      }
    );
  }
}
