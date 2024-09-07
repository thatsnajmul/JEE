export interface Job {
    id?: number;
    jobTitle: string;
    companyName: string;
    jobType: string;
    jobLocation: string;
    jobExperience: string;
    jobMinSalary: string;
    jobMaxSalary: string;
    jobCategory: string;
    jobDeadline: string; // Use date type for form control
    companyImage: string;
    jobDescription: string;
  }
  