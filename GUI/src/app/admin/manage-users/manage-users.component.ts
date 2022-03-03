import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.scss']
})
export class ManageUsersComponent implements OnInit {
  users: User[]=[];
  userForm!: FormGroup;
 
  constructor(private http: HttpClient){}

  ngOnInit(): void {
      this.userForm = new FormGroup({
        mail: new FormControl(null, [Validators.required, Validators.email]),
        password: new FormControl(null, Validators.required)
      });
  }

 fetchUsers(){
    this.http.get("https://cyberage-shield-default-rtdb.firebaseio.com/add.json").subscribe(
      allUsers => {
        console.log(allUsers);
      }
    );
  }

  

  public addUser(): void{
    this.users.push(this.userForm.value);

  }
  // remove(user){
  //   this.users.forEach((value,index) => {

  //     if (value==user) this.users.splice(index,1);
  //   });
  // }

  onSave(userData: {mail: string; password: string}){
    this.http.post("https://cyberage-shield-default-rtdb.firebaseio.com/add.json",userData)
    .subscribe((res)=>{
      console.log(res);
    });
    this.userForm.reset();
  }

  // constructor() { }
  // users: User[]= [
  //   new User("gadenagaramya9@gmail.com","gn9123")];

  // ngOnInit(): void {
  // }
  //public addUserForm !: FormGroup;
  //constructor(private formBuilder: FormBuilder, private http: HttpClient,private router: Router){}
  // AddUserBtnClicked=false;
  // users: User[]= [
  //         new User("gadenagaramya9@gmail.com","gn9123")];
  // ngOnInit(): void {
  //   this.addUserForm = this.formBuilder.group({
  //     email: new FormControl('',[Validators.required,Validators.email]),
  //     password: new FormControl('',[Validators.required])
  //   })
  // }
  // addUserClicked(){
  //   this.AddUserBtnClicked = !this.AddUserBtnClicked;
  // }
  // onSave(){
  //   alert("Successfully added the user");
  // }

}
