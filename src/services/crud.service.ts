import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Food } from 'src/object/food';


@Injectable({
  providedIn: 'root'
})
export class CrudService {

  food:{foodName:string,foodPrice:string}[]=[{
    foodName:"Chicago Pizza.",
    foodPrice:"500"
  },
  {
    foodName:"Sicilian Pizza",
    foodPrice:"300"
  },
  {
    foodName:"Greek Pizza",
    foodPrice:"550"
  },{
    foodName:"Cheese Dominor",
    foodPrice:"500"
  },
  {
    foodName:"New York-Style Pizza",
    foodPrice:"750"
  },
  {
    foodName:"Detroit Pizza.",
    foodPrice:"900"
  }]
  
  constructor(private http:HttpClient) { 

  }



  addfood(samar:number ,userName:any):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.post<any>("http://localhost:7000/samar-api-v2/user/"+userName+"/food",this.food[samar],requestOptions)
  }
  removefood(samar:number ,userName:any):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.delete<any>("http://localhost:7000/samar-api-v2/user/"+this.food[samar].foodName+"/"+userName,requestOptions)
  }
  getAllOrder(userName:any):Observable<any[]>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.get<any[]>("http://localhost:7000/samar-api-v2/user/"+userName+"/orders",requestOptions)
  }


  // ================================================
  removefood2(samar:any ,userName:any):Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
    return this.http.delete<any>("http://localhost:7000/samar-api-v2/user/"+samar+"/"+userName,requestOptions)
  }
}
