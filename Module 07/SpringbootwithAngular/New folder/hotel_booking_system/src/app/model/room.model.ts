import { Hotel } from "./hotel.model";


export class Room{

id!:number;
roomType!: string;
image!:string;
price!: number;
area!: number;
adultNo!: number;
childNo!: number;
avilability!: boolean;

hotel!:Hotel;



}