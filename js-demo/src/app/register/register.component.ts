// import {Component, OnInit} from '@angular/core';
// import {FormControl, FormGroup, Validators} from "@angular/forms";
//
// @Component({
//   selector: 'app-register',
//   templateUrl: './register.component.html',
//   styleUrls: ['./register.component.scss']
// })
// export class RegisterComponent implements OnInit {
//   registerFormInstance!: FormGroup;
//   ufc!: FormControl;
//   pfc!: FormControl;
//   cpfc!: FormControl;
//
//   ngOnInit() {
//     this.ufc = new FormControl('Initial Value', [Validators.required, Validators.email]);
//     this.pfc = new FormControl();
//     this.cpfc = new FormControl();
//     this.registerFormInstance = new FormGroup({
//       username: this.ufc,
//       password: this.pfc,
//       confirmPassword: this.cpfc
//     });
//
//     // autocomplete
//     this.ufc.valueChanges
//       .subscribe(val => console.log(val));
//   }
//
// }


import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerFormInstance!: FormGroup;

  constructor(private fb: FormBuilder) {}

  /* return null | {}
  *  null means no error, object means there is an error. follow this format: {errorCode: errorMessage}
  * */
  // destructuring        const {0: lol} = {0: 'LOL'}
  // const {value: {password, confirmPassword}} = {..., value: password: '', confirmPassword: ''}};
  static passwordValidator({value: {password, confirmPassword}}: FormGroup): null | {passwordsNotMatch: string} {
    return password === confirmPassword ? null : {passwordsNotMatch: 'P and CP are not the same'};
  }

  ngOnInit() {
    this.registerFormInstance = this.fb.group({
      username: ['', [Validators.email, Validators.required]],  // '' default value
      passwordGroup: this.fb.group({
        password: [''],
        confirmPassword: ''
      }, {validators: [RegisterComponent.passwordValidator]})
    });
  }
}
