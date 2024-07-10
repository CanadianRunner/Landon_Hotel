import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  getWelcomeMessages(): Observable<string[]> {
    return this.http.get<string[]>('/api/welcome');
  }
}
