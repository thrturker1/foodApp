import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-getOrder',
  templateUrl: './getOrder.component.html',
  styleUrls: ['./getOrder.component.css']
})
export class GetOrderComponent implements OnInit {

  constructor(private activeRoute:ActivatedRoute, private http:HttpClient) { }

  foodId:number = 0;
  food:foods =  {
    id: 0,
    name: "",
    alergens: "",
    company: "",
    count: 0,
    image: "",
    prize: 0,
    type: ""
  };

  inputName:string = "";
  inputAdres:string = "";
  inputCount:number = 0;
  ngOnInit() {
    this.activeRoute.params.subscribe(res=>{
      this.foodId = res['foodid']
    })
    this.http.get<foods>(`http://localhost:8080/api/foods/${this.foodId}`).subscribe(res=>{
    this.food = res;
    })
  }


  createOrder(){
  this.http.post<order>('http://localhost:8080/api/orders',{
       id: 0,
       customerName: this.inputName,
       productName: this.food.name,
       totalPrize: this.inputCount*this.food.prize,
       totalCount: this.inputCount,
     }).subscribe(res=>{
       if (res.id) {
         alert("Sipariş Başarılı");
       }
       else{
         alert("Bir hata oluştu");
       }
     })
  //alert("Sipariş Başarılı"); //Live da yorum satırına al 
  }
}

interface order {
  id: number;
  customerName: string;
  productName: string;
  totalPrize: number;
  totalCount: number;

}
interface foods {
  id: number;
  name: string;
  count: number;
  prize: number;
  alergens: string;
  company: string;
  type: string;
  image: string;

}