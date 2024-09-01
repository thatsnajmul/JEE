import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {Job} from "../model/job.model";
import {JobService} from "../service/job/job.service";
import {UserprofileService} from "../service/userprofile/userprofile.service";
import {Application} from "../model/applications.model";
import { UserModel } from '../model/user.model';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit{

  jobs: Job[] = [];  // Changed the property name to 'jobs' for consistency
  applications: Application[] = [];
  users: UserModel[] = [];
  

  constructor(
    private http: HttpClient,
    private jobService: JobService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadData();
    this.getJobApplications();
    this.http.get<{ id: string, name: string, email: string, password: string, role: string }[]>('http://localhost:3000/user')
      .subscribe(
        data => {
          this.userCount = data.length;
        },
        error => {
          console.error('Error fetching users:', error);
        }
      );
      this.http.get<{ id: string, title: string, description: string, location: string, company: string, type: string }[]>('http://localhost:3000/jobs')
      .subscribe(
        data => {
          this.jobsCount = data.length;
        },
        error => {
          console.error('Error fetching users:', error);
        }
      );
      this.http.get<{ id: string, name: string, email: string, phone: string, resume: string, coverLetter: string, jobId: string }[]>('http://localhost:3000/applications')
      .subscribe(
        data => {
          this.jobApplicationCount = data.length;
        },
        error => {
          console.error('Error fetching users:', error);
        }
      );


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

  loadData(): void {
    this.jobService.getAllJobs().subscribe({
      next: (jobs) => {
        this.jobs = jobs;  // Updated the variable name to 'jobs'
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  deleteJob(jobId?: string): void {
    this.jobService.deleteJob(jobId).subscribe({
      next: () => {
        this.loadData(); // Refresh the list after deletion
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  updateJob(jobId?: string): void {
    this.router.navigate(['/admin', jobId]);
  }

  userCount: number = 0;
  jobsCount: number = 0;
  jobApplicationCount: number = 0;



  

}


