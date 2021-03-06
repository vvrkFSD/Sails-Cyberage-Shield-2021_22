import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  

public loginForm !: FormGroup;
constructor(private formBuilder: FormBuilder, private http: HttpClient,private router: Router){}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: new FormControl('',[Validators.required,Validators.email]),
      password: new FormControl('',[Validators.required])
    })
  }

  onLogin(){
    // this.http.get<any>("url/Users").
    // subscribe(res=>{
    //           const user = res.find((a:any)=>{
    //             return a.email === this.loginForm.value.email && a.password === this.loginForm.value.password
    //           });
    //           if(user){
    //             alert("Login Success!");
    //             this.loginForm.reset();
    //             this.router.navigate(['forgot-password'])
    //           }
    //           else{
    //             alert("User not found");
    //           }
    //         },err=> {
    //           alert("Something Went Wrong");
    //         })
    const user = this.loginForm.value.email==="n161249@rguktn.ac.in" && this.loginForm.value.password==="12345678";
    if(user){
      alert("Login Success!");
      this.loginForm.reset();
      this.router.navigate(['admin-header'])
      }
    else{
        alert("User not found");
    }
  }
}


