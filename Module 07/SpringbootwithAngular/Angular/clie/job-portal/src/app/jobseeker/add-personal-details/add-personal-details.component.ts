import { Component, OnInit } from '@angular/core';
import { PersonalDetailsService } from '../../service/personal-details/personal-details.service';
import { PersonalDetails } from '../../model/personal-details-model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-add-personal-details',
  templateUrl: './add-personal-details.component.html',
  styleUrl: './add-personal-details.component.css'
})
export class AddPersonalDetailsComponent implements OnInit{

  
  personalDetailsForm!: FormGroup;
  personalDetailsId: number | null = null;  // to store the ID when in edit mode

  constructor(
    private formBuilder: FormBuilder,
    private personalDetailsService: PersonalDetailsService // Inject the service here
  ) {}

  ngOnInit(): void {
    this.initializeForm();
    this.loadPersonalDetails();
  }

  // Initialize the form
  initializeForm(): void {
    this.personalDetailsForm = this.formBuilder.group({
      firstName: ['', ],
      lastName: ['', ],
      gender: ['', ],
      birthday: ['', ],
      email: ['', [, ]],
      phone: ['', ],
      website: [''],
      address: ['', ],
      city: ['', ],
      country: ['', ],
      zipCode: ['', ],
      computerSkills: ['', ],
      languageSkills: ['', ],
      instituteName1: ['', ],
      subjectName1: ['', ],
      passingYear1: [null, ],
      gpa1: [null, ],
      companyName1: ['', ],
      designation1: ['', ],
      workStartDate1: ['', ],
      workEndDate1: [''],
      jobIntro1: ['', ],
      certificationName: ['', ],
      certificationYear: [null, ],
      certificationCourse: ['', ],
      awardName: ['', ],
      awardYear: [null, ],
      interestIntro: ['', ],
    });
  }

  // Load the personal details (for edit mode)
  loadPersonalDetails(): void {
    if (this.personalDetailsId) {
      this.personalDetailsService.getPersonalDetailsById(this.personalDetailsId).subscribe(details => {
        this.personalDetailsForm.patchValue(details);
      });
    }
  }

  // Create or update logic
  createOrUpdatePersonalDetails(): void {
    if (this.personalDetailsForm.valid) {
      const personalDetailsData = this.personalDetailsForm.value;

      if (this.personalDetailsId) {
        // Update existing personal details
        this.personalDetailsService.updatePersonalDetails(this.personalDetailsId, personalDetailsData)
          .subscribe(response => {
            console.log('Personal details updated successfully:', response);
          }, error => {
            console.error('Error updating personal details:', error);
          });
      } else {
        // Create new personal details
        this.personalDetailsService.createPersonalDetails(personalDetailsData)
          .subscribe(response => {
            console.log('Personal details created successfully:', response);
          }, error => {
            console.error('Error creating personal details:', error);
          });
      }
    } else {
      console.error('Form is invalid. Please check all required fields.');
    }
  }
  

}
