import {Pipe, PipeTransform} from "@angular/core";
import {Product} from "../models/product.model";

/* *****  pipe
*  pure changes:    primitive value changes or object reference change
*  impure changes:  other than pure changes, such as array element changes or object property changes
*
*   pure pipe:    a pipe can detect pure changes only
*   impure pipe:  a pipe can detect all the changes
* */
// by default, a pure pipe
@Pipe({
  name: 'priceRange',
  // default: true
  pure: false
})
export class PriceRangePipe implements PipeTransform {
  transform(products: Product[], min: number | null, max: number | null): Product[] {  /// ...args: rest operator: array-like
    min = min || Number.MIN_VALUE;
    max = max || Number.MAX_VALUE;
    return products.filter(p => p.price >= min! && p.price <= max!);  // !: DON'T WORRY
  }
}
