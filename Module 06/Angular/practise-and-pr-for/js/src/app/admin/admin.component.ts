import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  jobs: any[] = [];

  constructor(private jobService: JobService) {}

  ngOnInit() {
    this.jobService.getJobs().subscribe((data: any) => {
      this.jobs = data;
    });
  }
}

