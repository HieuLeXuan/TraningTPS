import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { ValidateEqualModule } from 'ng-validate-equal';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { DetailImgComponent } from './detail-img/detail-img.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DetailImgAdComponent } from './detail-img-ad/detail-img-ad.component';
import { DetailUserAdComponent } from './detail-user-ad/detail-user-ad.component';
import { NotfoundComponent } from './notfound/notfound.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    BoardAdminComponent,
    ProfileComponent,
    RegisterComponent,
    BoardUserComponent,
    DetailImgComponent,
    DetailImgAdComponent,
    DetailUserAdComponent,
    NotfoundComponent,
  ],
  imports: [BrowserModule, HttpClientModule, FormsModule, AppRoutingModule, MDBBootstrapModule.forRoot(), BrowserAnimationsModule, ValidateEqualModule],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent],
})
export class AppModule {}
