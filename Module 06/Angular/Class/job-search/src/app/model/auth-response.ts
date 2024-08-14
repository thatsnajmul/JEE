import { employeerModel } from "../model/employeer.model";
import { jobSeekerModel } from "../model/jobSeeker.model";

export interface AuthResponse {
    employeertoken:string;
    jobseekertoken:string;
    employeerUser:employeerModel;
    jobSeekerUser:jobSeekerModel;
}