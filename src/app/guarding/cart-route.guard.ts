import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginuserService } from 'src/services/loginuser.service';

@Injectable({
  providedIn: 'root'
})
export class CartRouteGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.checkstatus();
  }
  constructor(private router:Router,private loginservice:LoginuserService){

  }
  checkstatus(){
    if(this.loginservice.login==true){
  return this.loginservice.login
  }
  else{
  
    return this.router.navigateByUrl('/login')
  }
  
}}
