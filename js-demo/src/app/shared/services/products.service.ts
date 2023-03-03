import {Injectable} from "@angular/core";
import {Product} from "../models/product.model";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {environment} from "../../../environments/environment.development";

@Injectable()
export class ProductsService {
  // private products: Product[] | undefined = [];
  // private products = [
  //   // tslint:disable-next-line:max-line-length
  //   {id: 1, name: 'iPhone', brand: 'Apple', price: 100, stock: 22, image: 'https://d2um6umu4gwssp.cloudfront.net/apple/wp-content/uploads/2016/06/iphone-1.jpg'},
  //   {id: 2, name: 'iPhone3G', brand: 'Apple', price: 200, stock: 33, image: 'https://cdn.mos.cms.futurecdn.net/005cd70c02c2c8bd7b07d3cfeca82a3a.jpg'},
  //   {id: 3, name: 'iPhone3GS', brand: 'Apple', price: 300, stock: 11, image: 'https://technabob.com/blog/wp-content/uploads/2009/06/iphone_3gs.jpg'},
  //   {id: 4, name: 'iPhone4', brand: 'Apple', price: 400, stock: 22, image: 'https://www.imore.com/sites/imore.com/files/field/image/2014/03/topic_iphone_4.png'},
  //   {id: 5, name: 'iPhone4S', brand: 'Apple', price: 500, stock: 33, image: 'https://www.imore.com/sites/imore.com/files/field/image/2014/03/topic_iphone_4s.png'},
  //   {id: 6, name: 'iPhone5', brand: 'Apple', price: 600, stock: 11, image: 'https://www.imore.com/sites/imore.com/files/field/image/2014/03/topic_iphone_5.png'},
  //   {id: 7, name: 'iPhone5C', brand: 'Apple', price: 700, stock: 222, image: 'https://www.notebookcheck.net/uploads/tx_nbc2/N48-Blue.jpg'},
  //   {id: 8, name: 'iPhone5S', brand: 'Apple', price: 800, stock: 333, image: 'https://www.imore.com/sites/imore.com/files/field/image/2014/03/topic_iphone_5s.png'},
  //   {id: 9, name: 'iPhone6', brand: 'Apple', price: 900, stock: 111, image: 'https://support.apple.com/library/APPLE/APPLECARE_ALLGEOS/SP705/SP705-iphone_6-mul.png'}
  // ];

  // 2 : http --> 4.3 httpClient (module)
  constructor(private httpClient: HttpClient) {}


  // getProducts(): Product[] {
  //   return this.products;
  // }

  getProduct(id: number): Observable<Product | undefined> {
    return this.httpClient.get<Product>(`${environment.api_url}/products/${id}`)
    // return this.products.find((p) => {
    //   return p.id === id;
    // });
    // return this.products.find(p => p.id === id);
  }

  getProducts(): Observable<Product[] | undefined> {
    return this.httpClient.get<Product[]>(`${environment.api_url}/products`)
      .pipe(map(products => {  // don't mutate products, use copy
        return products.map(p => {
          p.price *= 0.5;
          return p;
        });
      }));
    //   .then(products=> this.products = products)
    //   .catch();
    // return this.products;
  }

}


