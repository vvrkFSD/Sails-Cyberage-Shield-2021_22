import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { ManageUsersComponent } from './admin/manage-users/manage-users.component';
import { ForgotPasswordComponent } from './common-components/forgot-password/forgot-password.component';
import { LoginComponent } from './common-components/login/login.component';

const routes: Routes = [
  {path: "", redirectTo: "login",pathMatch: "full"},
  {path: "login", component: LoginComponent},
  {path: "forgot-password", component: ForgotPasswordComponent},
  {path: "admin-header", component: AdminHeaderComponent},
  {path: "manage-users", component: ManageUsersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
