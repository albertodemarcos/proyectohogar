import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './views/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent }, // Ruta al componente de login
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redirige la ruta raíz al componente de login
  { path: '**', redirectTo: '/login' } // Redirige cualquier otra ruta al componente de login
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
