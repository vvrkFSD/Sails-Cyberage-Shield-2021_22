
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './common-components/login/login.component';
import { ForgotPasswordComponent } from './common-components/forgot-password/forgot-password.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { ManageUsersComponent } from './admin/manage-users/manage-users.component'
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ManageTopicsComponent } from './admin/manage-topics/manage-topics.component';
import { UserStatusComponent } from './admin/user-status/user-status.component';
import { UserListComponent } from './admin/manage-users/user-list/user-list/user-list.component';
import { EditUserComponent } from './admin/manage-users/user-list/edit-user/edit-user.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ForgotPasswordComponent,
    AdminHeaderComponent,
    ManageUsersComponent,
    ManageTopicsComponent,
    UserStatusComponent,
    UserListComponent,
    EditUserComponent,
    AdminDashboardComponent,
    EditProfileComponent
    
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

