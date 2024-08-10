export interface Job {
    id: number;
    title: string;
    description: string;
    company: string;
    location: string;
    postedBy: number; // user ID of the person who posted the job
  }
  