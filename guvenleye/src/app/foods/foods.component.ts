import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'; 

@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})
export class FoodsComponent implements OnInit {

  constructor(private activeRoute: ActivatedRoute, private http: HttpClient, private router:Router) { }

  filterAlergen: string = "";
  filterAlergenArray: string[] = [];

  foodsData: foods[] = [];
  foodsDataShow: foods[] = [];


  ngOnInit() {
    this.activeRoute.params.subscribe(res => {
      this.filterAlergen = res['filter'];
      this.filterAlergenArray = this.filterAlergen.split(',');
      this.filterAlergenArray.pop();

    })
    this.http.get<foods[]>('http://localhost:8080/api/foods/getAll').subscribe(res=>{
    this.foodsData  = res;


    this.filterAlergenArray.forEach(element => {
      this.foodsData = this.foodsData.filter(x => !element.includes(x.alergens))
    })
    this.foodsDataShow = this.foodsData;
    })
  }


  filterCategory(category: string) {
    if (category == "res") {
      this.foodsDataShow = this.foodsData;
    }
    else{
      this.foodsDataShow = this.foodsData.filter(x => x.foodType == category);

    }
  }
  filterPrice(category: number) {
    if (category == 0) {
      this.foodsDataShow = this.foodsData;
    }
    else{
      this.foodsDataShow = this.foodsData.filter(x => x.prize <= category &&  x.prize >= category-20);

    }
  }
  gotoOrderPage(id:number){
    this.router.navigate(['order/'+id]);
  }
}


interface foods {
  id: number;
  name: string;
  count: number;
  prize: number;
  alergens: string;
  companyName: string;
  foodType: string;
  image: string;

}
