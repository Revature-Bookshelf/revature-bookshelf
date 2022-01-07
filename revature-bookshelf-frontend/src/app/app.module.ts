import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

import { BookListComponent } from './book-list/book-list.component';
import { BookViewComponent } from './book-view/book-view.component';
import { LoginComponent } from './login/login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { SearchComponent } from './search/search.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { CartAccessComponent } from './cart-access/cart-access.component';
import { JwtInterceptorInterceptor } from './jwt-interceptor.interceptor';
import { AuthGuard } from './auth.guard';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule, Routes } from "@angular/router";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', pathMatch: "full", redirectTo: "index.html"},
  { path: 'login', component: LoginComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CartViewComponent,
    UserProfileComponent,
    EditProfileComponent,
    SearchComponent,
    CartAccessComponent,
    BookListComponent,
    BookViewComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }