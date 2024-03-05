import { Component } from '@angular/core';

import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  username!: string;
  password!: string;

  constructor(private authService: AuthService) { }


  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: (response: any) => {
        console.log('Login exitoso', response);
        window.location.href = 'https://www.ejemplo.com/pagina-no-angular';
      },
      error: (error: any) => {
        console.error('Error en el login', error);
      }
    });
  }
}
