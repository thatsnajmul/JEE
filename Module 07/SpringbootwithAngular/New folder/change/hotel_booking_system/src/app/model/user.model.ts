import { Role } from "./Role.model";
import { Token } from "./toke.model";

export class User {
    id!: number;
    name!: string;
    email!: string;
    password!: string;
    cell!: string;
    address!: string;
    dob!: Date;
    gender!: string;
    image!: string;
    active!: boolean;
    lock!: boolean;
    role!: String;
  
    tokens!: Token[];
  
    
  }