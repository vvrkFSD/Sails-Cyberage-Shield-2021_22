
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './common-components/login/login.component';
import { ForgotPasswordComponent } from './common-components/forgot-password/forgot-password.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ManageUsersComponent } from './admin/manage-users/manage-users.component'
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
<<<<<<< Updated upstream
import { DashboardComponent } from './common-components/dashboard/dashboard.component';
=======
import { ResetpasswordComponent } from './common-components/resetpassword/resetpassword.component';
>>>>>>> Stashed changes

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ForgotPasswordComponent,
    AdminHeaderComponent,
    ManageUsersComponent,
<<<<<<< Updated upstream
    DashboardComponent
=======
    ResetpasswordComponent
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

