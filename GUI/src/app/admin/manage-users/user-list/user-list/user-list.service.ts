import { Injectable, EventEmitter } from '@angular/core';
import { Subject } from 'rxjs';
import { User } from 'src/app/models/user.model';

@Injectable({
   providedIn: 'root'
 })

export class UserListService{
    usersChanged = new Subject<User[]>();
    startedEditing = new Subject<number>(); 

      private users: User[]=[
        new User('1@gmail.com',"male","10-5-1999"),
        new User('2@gmail.com',"female", "5-7-2000")
      ];  

getUsers(){
    return this.users.slice();
}

getUser(index : number){
    return this.users[index];
}

addUser(user: User){
    this.users.push(user);
    this.usersChanged.next(this.users.slice());
}

addUsers(users: User[]){
   this.users.push(...users);
   this.usersChanged.next(this.users.slice());
}

updateUser(index : number, newUser : User){
    this.users[index] = newUser;
    this.usersChanged.next(this.users.slice());
}

deleteUser(index:number){
    this.users.splice(index, 1);
    this.usersChanged.next(this.users.slice());
}

}
