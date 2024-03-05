import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// Importa los módulos de PrimeNG que planeas reutilizar
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { CardModule } from 'primeng/card';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FormsModule,
    ButtonModule,
    InputTextModule,
    CardModule
  ],
  exports: [
    // Exporta FormsModule y los módulos de PrimeNG para que estén disponibles para los módulos que importen SharedModule
    FormsModule,
    ButtonModule,
    InputTextModule,
    CardModule
  ]
})
export class SharedModule { }
