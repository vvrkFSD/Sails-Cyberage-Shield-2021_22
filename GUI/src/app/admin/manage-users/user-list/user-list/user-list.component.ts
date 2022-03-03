// import { Component, OnDestroy, OnInit } from '@angular/core';
// import { Subscription } from 'rxjs';
// import { User } from 'src/app/models/user.model';
// import { UserListService } from './user-list.service';

// @Component({
//   selector: 'app-user-list',
//   templateUrl: './user-list.component.html',
//   styleUrls: ['./user-list.component.scss']
// })
// export class UserListComponent implements OnInit, OnDestroy {
//   users: User[] = [];
//   constructor(private userListService: UserListService) { }

//   ngOnInit(){
//     this.users = this.userListService.getUsers();
//     this.uChangeSub= this.userListService.usersChanged
//     private uChangeSub : Subscription;
//     .subscribe(
//       next: (users: User[]) => {
//         this.users = users;

//       }
//     );
//   }

//  ngOnDestroy(): void{
//    this.uChangeSub.unsubscribe();
//  }
  

// }

import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { User } from 'src/app/models/user.model';
import { UserListService } from './user-list.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit, OnDestroy {
    private subscription!: Subscription;
    users!: User[];
  constructor(private ulService: UserListService, private http: HttpClient) { }

  ngOnInit(){
    this.users = this.ulService.getUsers();
    this.subscription = this.ulService.usersChanged.subscribe(
      (users: User[]) => {
        this.users = users;
      }
    );
    // this.http.get<any>("http://localhost:9021/admin/users").subscribe(
    //   (data) => {
    //     console.log("working");
    //     console.log(data);
    //   },
    //   (error) => {
    //     console.log('error')
    //   }
    // )


  }

  onEditUser(index : number){
    this.ulService.startedEditing.next(index);
  }

  ngOnDestroy(): void {
      this.subscription.unsubscribe();
  }


}
