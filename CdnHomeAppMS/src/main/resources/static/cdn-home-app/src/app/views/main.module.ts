import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { MainPageComponent } from './main-page/main-page.component';
import { CustomersComponent } from './customers/customers.component';



@NgModule({
  declarations: [MainPageComponent, CustomersComponent],
  imports: [
    CommonModule,
    FormsModule, 
    SharedModule,
    HttpClientModule
  ]
})
export class MainModule { }
