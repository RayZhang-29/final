import {Component, OnInit} from "@angular/core";
import {Product} from "../../shared/models/product.model";
import {ProductsService} from "../../shared/services/products.service";
import {ActivatedRoute, Router} from "@angular/router";
import {switchMap} from "rxjs";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})

export class productDetailComponent implements OnInit {
  product: Product | undefined;
  id: number = 0;

  constructor(
    private ps: ProductsService,
    private ar: ActivatedRoute,
    private router: Router
  ) {}

  // switchMap: autocomplete
  ngOnInit(): void {
    // this.id = +this.ar.snapshot.params['id'];
    this.ar.paramMap
      .pipe(switchMap(params => {
        this.id = +(params.get('id') || 0);
        return this.ps.getProduct(this.id);
      }))
      .subscribe({
        next: product => this.product = product,
        error: err => console.log(err.message),
        complete: () => console.log('GetProduct finished!')
      });

      //  due to network, may display wrong item

      // .subscribe(params => {
      //   this.id = +(params.get('id') || 0);
      //   this.ps.getProduct(this.id)
      //     .subscribe({
      //       next: product => this.product = product,
      //       error: err => console.log(err.message),
      //       complete: () => console.log('GetProduct finished!')
      //     })
      //   // .then(product => this.product = product)
      //   // .catch();
      // });
  }

  next(): void {
    this.ps.getProducts()
      .subscribe(data => {
        const products = data || [];
        let idx = products?.findIndex(p => p.id === this.id) || 0;//  === !!
        idx = (++idx % products.length) || 0;
        this.id = products[idx]['id']!;
        this.router.navigate(['/product-detail', this.id]).catch();
      })
  }
}
