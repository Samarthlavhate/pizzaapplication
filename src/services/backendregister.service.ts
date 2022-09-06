import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/object/registeruser';


@Injectable({
  providedIn: 'root'
})
export class BackendregisterService {

  constructor(private http:HttpClient) { }
  
  postuser(data:any):Observable<any>{
        return this.http.post<any>(`http://localhost:7000/samar-api-v2/register`,data);
  }
}
