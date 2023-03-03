/*
*  How to create a component in Angular?
*   1. Create a class and add @Component decorator
*   2. supply corresponding metadata in the decorator
*   3. declare the component in app.module(or some other module)
*
* */

import {Component, OnInit} from "@angular/core";
import {Product} from "../shared/models/product.model";
import {ProductsService} from "../shared/services/products.service";
import {CurrencyService} from "../shared/services/currency.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  // template inline template
  // --------- required for above metadata --------
  styleUrls: ['./products.component.scss']
  // style
})


// ***** Angular lifecycle hook methods (exam)
export class ProductsComponent implements OnInit {
  products: Product[] | undefined;
  min: number | null = null;
  max: number | null = null;

  // ps: ProductsService;
  // // in angular, ew can inject service by type in constructor
  // constructor(ps: ProductsService) {
  //   this.ps = ps;
  // }

  // in angular, we can inject service by type in constructor
  // syntax sugar of above
  constructor(
    public ps: ProductsService,
    public cs: CurrencyService
  ) {}

  ngOnInit():void {
    this.ps.getProducts()
      .subscribe(products => this.products = products)
      // .then(products => this.products = products)
      // .catch();
  }

  addProduct(): void {
    this.products?.push(
      {id: 3, name: 'iPhone3GS', brand: 'Apple', price: 300, stock: 11, image: 'https://technabob.com/blog/wp-content/uploads/2009/06/iphone_3gs.jpg'}
    );
  }
}

