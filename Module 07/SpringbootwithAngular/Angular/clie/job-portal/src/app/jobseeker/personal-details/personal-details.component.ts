import { Component, OnInit } from '@angular/core';
import { PersonalDetailsService } from '../../service/personal-details/personal-details.service';
import { PersonalDetails } from '../../model/personal-details-model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrl: './personal-details.component.css'
})
export class PersonalDetailsComponent implements OnInit{
  
  personalDetailsForm: FormGroup;
  personalDetailsId: number | null = null; // To hold the ID of the personal details being edited

  constructor(private fb: FormBuilder, private personalDetailsService: PersonalDetailsService) {
    // Initialize the form with validators
    this.personalDetailsForm = this.fb.group({
        firstName: ['', ],
        lastName: ['', ],
        gender: ['', ],
        birthday: ['', ],
        email: ['', [, Validators.email]],
        phone: ['', ],
        address: ['', ],
        city: ['', ],
        country: ['', ],
        zipCode: ['', ],
        computerSkills: ['', ],
        languageSkills: ['', ],
        instituteName1: ['', ],
        subjectName1: ['', ],
        passingYear1: ['', [, ]],
        gpa1: ['', [, ]],
        companyName1: ['', ],
        designation1: ['', ],
        certificationName: ['', ],
        certificationYear: ['', [, ]],
        awardName: ['', ],
        awardYear: ['', [, ]],
        interestIntro: ['', ]
    });
  }

  ngOnInit() {
    this.loadPersonalDetails(); // Load initial details if needed
  }

  editMode: boolean = false;

  toggleEditMode() {
    this.editMode = !this.editMode;
  }

  loadPersonalDetails() {
    if (this.personalDetailsId) {
        this.personalDetailsService.getPersonalDetailsById(this.personalDetailsId).subscribe(details => {
            this.personalDetailsForm.patchValue(details);
        });
    }
}


createOrUpdatePersonalDetails() {
  if (this.personalDetailsForm.valid) {
    const personalDetailsData = this.personalDetailsForm.value;

    if (this.personalDetailsId) { // Check if we have an ID, meaning it's an update
      // Update existing personal details
      this.personalDetailsService.updatePersonalDetails(this.personalDetailsId, personalDetailsData)
        .subscribe(
          (response) => {
            console.log('Personal details updated successfully:', response);
            // Additional success logic here, e.g., show a notification, navigate away, etc.
          },
          (error) => {
            console.error('Error updating personal details:', error);
          }
        );
    } else {
      // Create new personal details
      this.personalDetailsService.createPersonalDetails(personalDetailsData)
        .subscribe(
          (response) => {
            console.log('Personal details created successfully:', response);
            // Additional success logic here, e.g., reset form, navigate, etc.
          },
          (error) => {
            console.error('Error creating personal details:', error);
          }
        );
    }
  } else {
    console.error('Form is invalid. Please check all required fields.');
  }
}


  updatePersonalDetails(id: number) {
    this.personalDetailsService.updatePersonalDetails(id, this.personalDetailsForm.value).subscribe(() => {
      this.loadPersonalDetails();
      this.personalDetailsId = null; // Reset ID after updating
      this.personalDetailsForm.reset(); // Reset the form if needed
    });
  }

  deletePersonalDetails(id: number) {
    this.personalDetailsService.deletePersonalDetails(id).subscribe(() => {
      this.loadPersonalDetails();
    });
  }

}
