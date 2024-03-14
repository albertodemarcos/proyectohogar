import { Component, OnInit } from '@angular/core';
import { MainService } from '../main.service';

@Component({
  selector: 'app-customers',
  standalone: false,
  templateUrl: './customers.component.html'
})
export class CustomersComponent implements OnInit {

  constructor(private mainService: MainService) { }

  ngOnInit(): void {
    this.viewDataCustomers();
  }

  viewDataCustomers(): void {

    this.mainService.viewDataCustomers().subscribe({
      next: (response: any) => {
        console.log('datos exitoso', response);
      },
      error: (error: any) => {
        console.error('Error en datos', error);
      }
    });

  }
  
}
