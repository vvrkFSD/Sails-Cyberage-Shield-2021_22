import { Component, OnInit } from '@angular/core';
import { User } from './user.model';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.scss']
})
export class ManageUsersComponent implements OnInit {

  constructor() { }
  users:User[]=[new User("gadenagaramya9@gmail.com","gn9123")];

  ngOnInit(): void {
  }

}
