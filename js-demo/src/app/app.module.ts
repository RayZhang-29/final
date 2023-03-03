import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProductsComponent} from "./products/products.component";
import {ProductOverviewComponent} from "./products/product-overview/product-overview.component";
import {HeaderComponent} from "./header/header.component";
import {HomeComponent} from "./home/home.component";
import {productDetailComponent} from "./products/product-detail/product-detail.component";
import {ProductsService} from "./shared/services/products.service";
import {PriceRangePipe} from "./shared/pipes/price-range.pipe";
import {CurrencyExchangePipe} from "./shared/pipes/currency.exchange.pipe";
import {MyShowDirective} from "./shared/directive/my-show.directive";
import {MyIfDirective} from "./shared/directive/my-if.directive";
import {CrahDirective} from "./shared/directive/crah.directive";
import {HttpClientModule} from "@angular/common/http";
import {LoginComponent} from "./login/login.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CustomStyleModule} from "./shared/modules/custom-style/custom-style.module";
import { RegisterComponent } from './register/register.component';
import { ParentComponent } from './home/parent/parent.component';
import { ChildComponent } from './home/parent/child/child.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductOverviewComponent,
    HeaderComponent,
    HomeComponent,
    productDetailComponent,
    PriceRangePipe,
    CurrencyExchangePipe,
    MyShowDirective,
    MyIfDirective,
    CrahDirective,
    LoginComponent,
    RegisterComponent,
    ParentComponent,
    ChildComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CustomStyleModule,
    ReactiveFormsModule
  ],
  providers: [ProductsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
