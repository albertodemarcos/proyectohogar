import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MainService {


  private static URL_PORTAL = 'homealovera.com';
  private static PREFIX_APP = '/api'; // PREFIJO al endpoint
  private static MAIN_APP = '/main';
  private static CUSTOMERS_APP = '/customers';

  constructor(private http: HttpClient) { }

  viewDataMain() {
    
    //let url = MainService.URL_PORTAL + MainService.PREFIX_APP + MainService.MAIN_APP;
    let url = MainService.PREFIX_APP + MainService.CUSTOMERS_APP;

    console.log("Se va a pedir datos a " + url);
    return this.http.get(url);
  }

  viewDataCustomers() {
    

    //let url = MainService.URL_PORTAL + MainService.PREFIX_APP + MainService.CUSTOMERS_APP;
    let url = MainService.PREFIX_APP + MainService.CUSTOMERS_APP;

    console.log("Se va a pedir datos a " + url);
    return this.http.get(url);
  }
}
