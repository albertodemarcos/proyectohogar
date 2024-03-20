import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  //private static URL_SSO_PORTAL = 'http://localhost:8090';

  private loginUrl = '/api/sso/auth/login'; // URL al endpoint de login en tu backend

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    //const url = AuthService.URL_SSO_PORTAL + this.loginUrl;
    const url = this.loginUrl;
    console.log("Se va a enviar={username: "+username+", password:"+ password+"}");
    console.log("Se envia a " + url);
    return this.http.post(url, {username, password}, {withCredentials: true});
  }
}
