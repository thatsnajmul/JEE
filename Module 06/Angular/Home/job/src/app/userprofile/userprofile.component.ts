import { Component, OnInit } from '@angular/core';
import { UserModel } from '../model/user.model';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { UserprofileService } from '../service/userprofile/userprofile.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';


import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';
import { cvData } from '../model/cvData.model';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrl: './userprofile.component.css'
})
export class UserprofileComponent implements OnInit{

  // Holds the active tab state
  activeTab: string = 'profile'; // Default tab
  activeTabs: string = 'view'; // Default tab
  

  // Method to set the active tab
  setActiveTab(tab: string) {
    this.activeTab = tab;
  }
  setActiveTabs(tab: string) {
    this.activeTabs = tab;
  }
  

  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  user: UserModel | null = null;
  private subscription: Subscription = new Subscription();

  constructor(
    private userProfileService: UserprofileService,
    private router: Router,
    private jobService: JobService
  ) { }

  ngOnInit(): void {
    this.loadUserProfile();
    this.getCvData();
  }

  loadUserProfile(): void {
    const sub = this.userProfileService.getUserProfile().subscribe({
      next: (user) => {
        if (user) {
          this.user = user;
        }
      },
      error: (err) => {
        console.error('Error loading user profile:', err);
        // You can handle the error further, e.g., showing an error message to the user
      }
    });

    this.subscription.add(sub);  // Manage the subscription
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();  // Unsubscribe when the component is destroyed
  }

  cvDatas: cvData[] = [];

  getCvData(): void {
    this.jobService.getAllCvData().subscribe(
      (data: cvData[]) => {
        this.cvDatas = data;
      },
      (error: any) => { // Using 'any' type
        console.error('There was an error fetching', error);
      }
    );
 
  }

  

}