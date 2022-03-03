import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { ManageTopicsComponent } from './admin/manage-topics/manage-topics.component';
import { ManageUsersComponent } from './admin/manage-users/manage-users.component';
import { EditUserComponent } from './admin/manage-users/user-list/edit-user/edit-user.component';
import { UserListComponent } from './admin/manage-users/user-list/user-list/user-list.component';
import { UserStatusComponent } from './admin/user-status/user-status.component';
import { ForgotPasswordComponent } from './common-components/forgot-password/forgot-password.component';
import { LoginComponent } from './common-components/login/login.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';

const routes: Routes = [
  {path: "", redirectTo: "login",pathMatch: "full"},
  {path: "login", component: LoginComponent},
  {path: "forgot-password", component: ForgotPasswordComponent},
  {path: "admin-header", component: AdminHeaderComponent},
  {path: "manage-users", component: ManageUsersComponent},
  {path: "user-list", component:UserListComponent},
  {path: "edit-user", component: EditUserComponent},
  {path: "manage-topics", component: ManageTopicsComponent},
  {path: "user-status", component: UserStatusComponent},
  {path: "edit-profile", component: EditProfileComponent},
  {path: "admin-dashboard", component: AdminDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
