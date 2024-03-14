import { Component } from '@angular/core';

import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  private static URL_PORTAL = 'homealovera.com';

  username!: string;
  password!: string;

  constructor(private authService: AuthService) { }

  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: (response: any) => {
        console.log('Login exitoso', response);
        //window.location.href = 'http://'+LoginComponent.URL_PORTAL;
        window.location.href = 'http://localhost:4201';
      },
      error: (error: any) => {
        console.error('Error en el login', error);
      }
    });
  }
}
