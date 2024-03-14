import { Component, OnInit } from '@angular/core';
import { MainService } from '../main.service';

@Component({
  selector: 'app-main-page',
  standalone: false,
  templateUrl: './main-page.component.html'
})
export class MainPageComponent implements OnInit {

  constructor(private mainService: MainService) { }
  
  ngOnInit(): void {
    this.viewDataMain();  
  }

  viewDataMain(): void {

    this.mainService.viewDataMain().subscribe({
      next: (response: any) => {
        console.log('datos exitoso', response);
      },
      error: (error: any) => {
        console.error('Error en datos', error);
      }
    });

  }

}
