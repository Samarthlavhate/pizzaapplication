import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormControl, FormGroup, MinLengthValidator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginuserService } from 'src/services/loginuser.service';
import { User } from '../../object/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(private router:Router, private logserve:LoginuserService ) { }

  ngOnInit(): void {
   
   
  }

  messages:any='User Successfully logged in'
  logincred:any=false;
  myuser:User=new User("","");

  profileForm = new FormGroup({
    user : new FormControl('', [Validators.required]),
    pass : new FormControl('', [Validators.required])
  })
  getusername() {
    return this.profileForm.controls.user
    }

  getpassword() {
    return this.profileForm.controls.pass
  }
  hide = true;
    onsubmit(){
       
     
      
      this.logserve.loginuser(this.myuser).subscribe(c=>{    
        c.message=this.messages
         if(this.messages==c.message){
          window.alert("login in successfully")
          this.logserve.authconfirm(true)
         sessionStorage.setItem("token",c.token)
          this.router.navigateByUrl('/')
        }    
        }
        
        
       
      
      )
      
      
     
     
     
     
     
    }
    
   

}
