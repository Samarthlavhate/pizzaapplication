import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from 'src/services/crud.service';
import { FoodService } from 'src/services/food.service';
import { LoginuserService } from 'src/services/loginuser.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private foodserv:FoodService,private crud:CrudService, private logserc:LoginuserService, private route:Router) { 
   
  }

  recdata:any
 

  
  ngOnInit() {
    this.crud.getAllOrder(this.logserc.user.userName).subscribe(c=>{
      this.recdata=c
    })
    
  }
  // ===============================================================
  press(){
    for (let index = 0; index < this.recdata.food.length; index++) {
      this.crud.removefood2(this.recdata.food[index].foodName,this.logserc.user.userName).subscribe()

    }
    alert("order done successfully")
    // for (let index = 0; index < this.recdata.food.length; index++) {
    //   this.crud.removefood2(this.recdata.food[index].foodName,this.logserc.user.userName).subscribe()

    // }
this.route.navigateByUrl("/")
  }

}
