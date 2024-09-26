import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Hotel } from '../model/hotel.model';
import { Room } from '../model/room.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  baseUrl:string="http://localhost:8080/api/room/";

  constructor(
    private httpClient: HttpClient
  ) { }


  getAllRooms():Observable<any>{

    return this.httpClient.get(this.baseUrl);

  }

  getRoomByHotel(id:string): Observable<Room[]> {

    return this.httpClient.get<Room[]>(this.baseUrl+"r/searchroombyid?hotelid="+id)
      .pipe(
        catchError(this.handleError)
    )

  }


  private handleError(error:any) {
    console.error('An error occurred:', error);
    return throwError(() => new Error('test'));
  }


  createRoom(room: Room): Observable<any> {

    return this.httpClient.post(this.baseUrl+"/save", room);


  }

  deleteRoom(id: number): Observable<any> {
    return this.httpClient.delete(this.baseUrl + "/" + id);
    
  }

  updateRoom(id: string, room: Room): Observable<any> {

    return this.httpClient.put(this.baseUrl + "/" + id, room);

  }

  getById(id: string): Observable<any> {

    return this.httpClient.get(this.baseUrl + "/" + id);

  }

}
