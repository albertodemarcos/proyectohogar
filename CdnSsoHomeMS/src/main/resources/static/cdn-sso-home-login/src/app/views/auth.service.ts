import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  private loginUrl = '/login'; // URL al endpoint de login en tu backend

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post(this.loginUrl, {username, password}, {withCredentials: true});
  }
}
