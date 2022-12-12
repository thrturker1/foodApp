import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FoodsComponent } from './foods/foods.component';
import { GetOrderComponent } from './getOrder/getOrder.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [

  {path : '', component: HomeComponent},
  {path: 'foods/:filter', component:FoodsComponent},
  {path: 'order/:foodid', component:GetOrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

