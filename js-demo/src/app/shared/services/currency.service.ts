import {Injectable} from "@angular/core";


@Injectable({
  providedIn: 'root'  // angular 6+, same a s adding it to providers
})
export class CurrencyService {
  currencyCode: string = 'USD';
}
