import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ProductsComponent} from "./products/products.component";
import {productDetailComponent} from "./products/product-detail/product-detail.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthGuard} from "./shared/guards/auth.guard";

/* How to set up routing in Angular
*  1. Set up the routing config
*  2. Use router link to change url (html)
*  3. Use router-outlet as a placeholder to load component dynamically
* */
const routes: Routes = [
  {
    path: 'home',  // no slash /
    component: HomeComponent
  },
  {
    path: 'products',
    component: ProductsComponent
  },
  {
    path: 'product-detail/:id',
    component: productDetailComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'prime',
    // lazy loading
    // angular 7 and before
    // loadChildren: './prime/prime.module#PrimeModule'
    // angular 8 and above
    loadChildren: () => import('./prime/prime.module').then(m => m.PrimeModule),
    // whether lazy loaded module can be loaded or not
    // canLoad: [AuthGuard]

    // whether the route can be activated or not
    canActivate: [AuthGuard]
  },
  // must be the last element of routes
  {
    path: '**',
    redirectTo: 'home'
  }
];

@NgModule({
  // create a root level routing, one application can have only one root level routing
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
