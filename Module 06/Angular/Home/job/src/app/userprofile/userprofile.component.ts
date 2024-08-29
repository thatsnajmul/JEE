import { Component } from '@angular/core';
import { UserModel } from '../model/user.model';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { UserprofileService } from '../service/userprofile/userprofile.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrl: './userprofile.component.css'
})
export class UserprofileComponent {

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
  ) { }

  ngOnInit(): void {
    this.loadUserProfile();

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



  //For Personal Details
  personaldetails = {
    name: '',
    email: '',
    phone: '',
    gender: '',
    dob: '',
    address: ''

  }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.userProfileService.submitpersonalDetails(this.personaldetails).subscribe({
        next: () => {
          alert(' submitted successfully!');
          form.reset();
        },
        error: (err) => {
          console.error('Error submitting: ', err);
          alert('Failed to submit');
        }
      });
    }
  }

  

}