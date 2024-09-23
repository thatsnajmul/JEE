// personal-details.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PersonalDetailsService } from '../../service/personal-details/personal-details.service';


@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrl: './personal-details.component.css'
})
export class PersonalDetailsComponent implements OnInit{
  
  personalDetailsForm: FormGroup;
    editMode = false;
    personalDetailsId!: number;

    constructor(private fb: FormBuilder, private detailsService: PersonalDetailsService) {
        this.personalDetailsForm = this.fb.group({
            firstName: ['', Validators.required],
            lastName: ['', Validators.required],
            gender: ['', Validators.required],
            birthday: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            phone: ['', Validators.required],
            website: [''],
            address: ['', Validators.required],
            city: ['', Validators.required],
            country: ['', Validators.required],
            zipCode: ['', Validators.required],
            computerSkills: ['', Validators.required],
            languageSkills: ['', Validators.required],
            instituteName1: ['', Validators.required],
            subjectName1: ['', Validators.required],
            passingYear1: ['', Validators.required],
            gpa1: ['', Validators.required],
            companyName1: ['', Validators.required],
            designation1: ['', Validators.required],
            certificationName: ['', Validators.required],
            certificationYear: ['', Validators.required],
            awardName: ['', Validators.required],
            awardYear: ['', Validators.required],
            interestIntro: ['', Validators.required],
        });
    }

    ngOnInit() {
        // Fetch existing details if in edit mode
        if (this.personalDetailsId) {
            this.detailsService.getPersonalDetails(this.personalDetailsId).subscribe(data => {
                this.personalDetailsForm.patchValue(data);
            });
        }
    }

    toggleEditMode() {
        this.editMode = !this.editMode;
    }

    createOrUpdatePersonalDetails() {
        if (this.editMode) {
            this.detailsService.updatePersonalDetails(this.personalDetailsId, this.personalDetailsForm.value).subscribe();
        } else {
            this.detailsService.createPersonalDetails(this.personalDetailsForm.value).subscribe();
        }
    }
  


 

}
