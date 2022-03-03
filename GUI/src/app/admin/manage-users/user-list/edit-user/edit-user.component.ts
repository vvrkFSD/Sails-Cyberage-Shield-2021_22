// import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
// import { User } from 'src/app/models/user.model';
// import { UserListService } from '../user-list/user-list.service';

// @Component({
//   selector: 'app-edit-user',
//   templateUrl: './edit-user.component.html',
//   styleUrls: ['./edit-user.component.scss']
// })
// export class EditUserComponent implements OnInit {
//   @ViewChild('mailInput') mailInputRef!: ElementRef;
//   @ViewChild('passwordInput') passwordInputRef!: ElementRef;
  

//   constructor(private userService: UserListService) { }

//   ngOnInit(): void {
//   }
//   onAddUser(){
//     const umail = this.mailInputRef.nativeElement.value;
//     const upassword = this.passwordInputRef.nativeElement.value;
//     const newUser = new User(umail,upassword);
//     this.userService.addUser(newUser);
    

//   }

// }

import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { User } from 'src/app/models/user.model';
import { UserListService } from '../user-list/user-list.service';
//import { EventEmitter } from 'stream';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit, OnDestroy {
  @ViewChild('f') ulForm !: NgForm;

  subscription!: Subscription;
  editMode = false;
  editedUserIndex!: number;
  editedUser!: User;

  constructor(private ulService : UserListService, private http: HttpClient) { }

  ngOnInit(){
    this.subscription = this.ulService.startedEditing.subscribe(
      (index : number) => {
        this.editedUserIndex = index;
        this.editMode = true;
        this.editedUser = this.ulService.getUser(index);
        this.ulForm.setValue({
          name : this.editedUser.mail,
          gender : this.editedUser.gender,
          dob: this.editedUser.dob
        })
      }
    );
  }

  onSubmit(form: NgForm){
    const value = form.value;
    const newUser = new User(value.name, value.gender, value.dob);


    if(this.editMode){
      this.ulService.updateUser(this.editedUserIndex, newUser);
    }
    else{
      this.ulService.addUser(newUser);
      this.http.post("http://localhost:9021/admin/users",newUser);
    }

    this.editMode = false;
    form.reset();   
    
  }

  onClear(){
    this.ulForm.reset();
    this.editMode = false;
  }

  onDelete(){
    this.ulService.deleteUser(this.editedUserIndex);
    this.onClear();
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
      
  }

}
