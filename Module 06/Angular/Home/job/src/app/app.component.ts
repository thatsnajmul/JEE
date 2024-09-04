import { Component, OnInit} from '@angular/core';
import { JobService } from '../app/service/job/job.service';
import { UserModel } from './model/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent  {
  title = 'job';  

  user: UserModel | null = null;

  jobs: any[] = [];

  constructor(private jobService: JobService) { }

 
}
