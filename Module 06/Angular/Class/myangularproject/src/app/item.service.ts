import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const apiUrl = 'http://localhost:3000/items';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  constructor(private http: HttpClient) {}

  getItems(): Observable<any> {
    return this.http.get(apiUrl);
  }

  getItem(id: number): Observable<any> {
    return this.http.get(`${apiUrl}/${id}`);
  }

  addItem(item: any): Observable<any> {
    return this.http.post(apiUrl, item);
  }

  updateItem(id: number, item: any): Observable<any> {
    return this.http.put(`${apiUrl}/${id}`, item);
  }

  deleteItem(id: number): Observable<any> {
    return this.http.delete(`${apiUrl}/${id}`);
  }
}

