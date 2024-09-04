import { Component, OnInit } from '@angular/core';
import { UserModel } from '../model/user.model';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { UserprofileService } from '../service/userprofile/userprofile.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { jsPDF } from 'jspdf';
import { AuthService } from '../service/auth/auth.service';


import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';
import { cvData } from '../model/cvData.model';
import { HttpClient } from '@angular/common/http';

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
    private jobService: JobService,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.loadUserProfile();
    this.getCvData();
    this.http.get('http://localhost:3000/cvdata')
      .subscribe(
        data => {
          this.cvData = data; // Assuming there's only one item
        },
        error => {
          console.error('Error fetching CV data:', error);
        }
      );
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
  
  cvData: any = {};
  generatePDF() {
    const doc = new jsPDF();

    // Add content to PDF
    doc.text('Curriculum Vitae', 10, 10);
    doc.text(`Full Name: ${this.cvData.fullName}`, 10, 20);
    doc.text(`Email: ${this.cvData.email}`, 10, 30);
    doc.text(`Phone: ${this.cvData.phone}`, 10, 40);
    doc.text(`Address: ${this.cvData.address}`, 10, 50);
    doc.text(`Degree: ${this.cvData.degree}`, 10, 60);
    doc.text(`Institution: ${this.cvData.institution}`, 10, 70);
    doc.text(`Company Name: ${this.cvData.companyName}`, 10, 80);
    doc.text(`Job Title: ${this.cvData.jobTitle}`, 10, 90);
    doc.text(`Job Description: ${this.cvData.jobDescription}`, 10, 100);
    doc.text(`Skills: ${this.cvData.skills}`, 10, 110);

    // Save the PDF
    doc.save('cvdata.pdf');
  }

}