import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './views/main-page/main-page.component';
import { CustomersComponent } from './views/customers/customers.component';

const routes: Routes = [
  { path: '', component: MainPageComponent }, // Ruta al componente de main
  { path: 'main', component: MainPageComponent }, // Ruta al componente de main
  { path: 'customers', component: CustomersComponent }, // Ruta al componente de customers
  { path: '', redirectTo: '/main', pathMatch: 'full' }, // Redirige la ruta raíz al componente de main
  { path: '**', redirectTo: '/main' } // Redirige cualquier otra ruta al componente de main
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
