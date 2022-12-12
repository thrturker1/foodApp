import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http: HttpClient, private router:Router) { }

  alergenData: Alergen[] = [
    { id: 1, name: "Gluten" },

    { id: 2, name: "Süt Ürünleri" },

    { id: 3, name: "Et Ürünleri" },

    { id: 4, name: "Deniz Ürünleri" }
  ]

alergenCheckedData: string = "";

  ngOnInit() {
    this.getAlergen(); // APİ url i methoda yazıp açabilirsin.
  }

  getAlergen() {
    this.http.get<Alergen[]>('http://localhost.com:8080/api/alergens/getAll').subscribe(res => {
      this.alergenData = res;
    })
  }


  fillAlergen() {
    this.alergenCheckedData = "";
    this.alergenData.forEach(element => {
      const checkbox = document.getElementById(
        element.id.toString(),
      ) as HTMLInputElement | null;

      if (checkbox?.checked) {
        this.alergenCheckedData = this.alergenCheckedData + element.name + ","
      } else {
      }
      
      this.router.navigate(['/foods/'+this.alergenCheckedData])
    });
    
  }
}


interface Alergen {
  id: number;
  name: string;
}