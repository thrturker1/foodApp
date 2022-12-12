import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FoodsComponent } from './foods/foods.component';
import { GetOrderComponent } from './getOrder/getOrder.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [		
    AppComponent,
    NavbarComponent,
    HomeComponent,
      FoodsComponent,
      GetOrderComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
