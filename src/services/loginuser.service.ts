import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/object/user';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
 login=false;
 user!:User
  constructor(private http:HttpClient) { }

  loginuser(data:any):Observable<any>{
    this.user=data
    return this.http.post<any>(`http://localhost:7000/samar-api/login`,data);
}
authconfirm(statement:any):any{
  return this.login = statement;
}

}
