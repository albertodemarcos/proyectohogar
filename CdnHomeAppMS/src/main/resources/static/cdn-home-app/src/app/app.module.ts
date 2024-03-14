import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { MainModule } from './views/main.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainModule,
    SharedModule
    // Aquí van otros módulos necesarios para tu aplicación, como FormsModule, HttpClientModule, etc.
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
