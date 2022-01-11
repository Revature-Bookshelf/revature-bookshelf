import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookListComponent } from './book-list/book-list.component';
import { BookViewComponent } from './book-view/book-view.component';
import { LoginComponent } from './login/login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { SearchComponent } from './search/search.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { CartAccessComponent } from './cart-access/cart-access.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';

// const routes: Routes = [{ path: 'books', component: BookListComponent }];

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'user-profile', component: UserProfileComponent },
  { path: 'edit-profile', component: EditProfileComponent },
  { path: 'search', component: SearchComponent },
  { path: 'cart-view', component: CartViewComponent },
  { path: 'cart-access', component: CartAccessComponent },
  { path: 'book-view', component: BookViewComponent },
  { path: 'book-list', component: BookListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
