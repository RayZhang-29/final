import {Component, Input} from "@angular/core";
import {Product} from "../../shared/models/product.model";
import {CurrencyService} from "../../shared/services/currency.service";

// import {Product} from 'shared'
@Component({
  selector: 'app-product-overview',
  templateUrl: './product-overview.component.html',
  styleUrls: ['./product-overview.component.sass']
})


export class ProductOverviewComponent {
  /*  Component communication
   P -> C : In child component.ts, use @Input decorator
                   on a variable that receives the data.
   */
  // @Input('myProduct')
  @Input()
  product: Product | undefined;

  constructor(public cs: CurrencyService) {}

}
