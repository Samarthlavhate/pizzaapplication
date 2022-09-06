import { Component, OnInit } from '@angular/core';
import {  FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/object/registeruser';


import { BackendregisterService } from '../../services/backendregister.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router:Router, private backend:BackendregisterService) { }


  registeredUser:User=new User("","","")

 

  hide = true;

    register= new FormGroup({
    userName:new FormControl('',[Validators.required]),
    userEmailId:new FormControl('',[Validators.required,Validators.email]) ,
    userPassword:new FormControl('',[Validators.required])})
    
  getEmailId(){
    return this.register.controls.userEmailId
  }
  getusername() {
    return this.register.controls.userName
    }

  getpassword() {
    return this.register.controls.userPassword
  }
  
  onsubmit(){
    this.backend.postuser(this.registeredUser).subscribe(c=>console.log(c));
    console.log(this.registeredUser.email)
    console.log(this.registeredUser.password)
    console.log(this.registeredUser.password)

    alert("register successfully")
   this.router.navigateByUrl('/login')

   
  }
  ngOnInit(): void {
    
  }
  }
