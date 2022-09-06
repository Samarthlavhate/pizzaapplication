
import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, Component, EventEmitter, OnDestroy, Output} from '@angular/core';
import { Observable } from 'rxjs';

import { User } from 'src/object/user';
import { CrudService } from 'src/services/crud.service';
import { FoodService } from 'src/services/food.service';
import { LoginuserService } from 'src/services/loginuser.service';
import { Order } from '../order';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnDestroy {

   mobileQuery: MediaQueryList;
 
   



  private _mobileQueryListener: () => void;

  constructor(changeDetectorRef: ChangeDetectorRef, media:MediaMatcher,private crud:CrudService ,private login :LoginuserService, private foodserv:FoodService) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }
  
  badgecount:number=0;

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }
 

  
onclick(samar:number){
  
  this.crud.addfood(samar,this.login.user.userName).subscribe(c=>{
    console.log(c)
  
  })
   this.badgecount=this.badgecount+1;


}
remove(samar2:number){
  if(this.badgecount>0){
   this.badgecount=this.badgecount-1;
  this.crud.removefood(samar2,this.login.user.userName).subscribe(c=>console.log(c))
}
this.crud.removefood(samar2,this.login.user.userName).subscribe(c=>console.log(c))

}
order!:any

getdata(){
this.crud.getAllOrder(this.login.user.userName).subscribe(c=>{
 console.log(c)

})


  

}}