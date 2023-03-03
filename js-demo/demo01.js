// 2.10
// 'use strict'; // will enable strict mode in js

/*  1. We use parenthesis to invoke a function/method (field == property)
	2. We use dot notation to accessa property
	
	prefer '' (golow convention)
	backe slash \', escape \
	semicolon: optional, recommended adding {}
	console.log() can take many parameters
*/ 

console.log('Hello \' World!');
console.log("Hello World!");


//  ES5 js primitive types

//	1. String
// type: string, value: hi string
// typeof: a operator, take 1 parameter
console.log('hi string', typeof 'hi string');  

// 2. boolean:  true/false
console.log(true, false, typeof true);

// 3. number
console.log(1, 0.1, .1, -.2, +0, -0);.
console.log(+0 == -0, Object.is(+0, -0));
console.log((.1 + .2).toFixed(2));

// 4. null : type and value are both null, it means nothing / has no value
// in fact, typeof null returns object is considered a bug in js
console.log(null, typeof null);

// 5. undefined: type and value are both null, it means nothing / has no value
var a;
console.log(a, typeof a);

// *** difference: null & undefined?
/*  null is typically assigned by developers to indicate it has no value;
	undefined is assigned to a variable that is declared without initialization 
*/

// if a is initialized, leave it alone
// else give it a value 1
// fn(a);
// if (a === undefined) {
// 	console.log('not initialized')
// } else {
// 	a = 1;
// 	console.log(1);
// }

var b = null;
// do not use == to compare in JS 
// ***difference: == & ===
// ===: it will compare both value and type
// ==: only compares value
console.log(a == b);  // true
console.log(a === b); // false



// if else
if (0) {
	console.log('truthy values');
} else {
	console.log('falsy values');
}

// 0: false, 2: true, 
// '': false, '0': true, 
// []、[0]: true 
// null: false

// 6 falsy values in JS: 
// false,   0,   '',   null,   undefined,   NaN(not a num)

// short-circuit evaluation
if (null || 1) {
	console.log('truthy values');
} else {
	console.log('falsy values');
}

var c = null;
if (!c && typeof c == 'object') {
	console.log('c is null');
} else { 
	console.log('c is not null');
}

// Referebce error, not defined error
// JS is rendering the file line by line
// try catch
try {
	console.log(d);
	console.log('after error');
} catch(e) {                  // e cannot be removed if having () --> Syntax Error  /  only catch
	// console.log(e.message);
	console.log('in catch');
} finally {
	console.log('finally')
}

/* function in js
	function fnName(params) {
		// function
	}
	there is no overloading in js
*/

// function hi() {
// 	console.log('hi', arguments[0]);  // default has arguments values hidden
// }

function hi() {
	console.log('hi');
}
hi('ZR');
// function hi(name) {
// 	console.log('hi', name);
// 	console.log('hi' + name);
// }


hi();  // run the second one [hi(name)]
hi('ray');  


// 2.13
// every function in js creates a scope(function scope)
// var creates a function-scoped variable
var name = 'alice';  // file scope, only avaiable in nodejs
function hello(name) {
	// var name;   local variable, shadows the outer scope var.
	var l = 'l';
	console.log(l);

	/*   when accessing a variable,
		 js will search local scope -> (closure) -> file scope -> global
		 if not found in global, reference error will throw
	*/
	console.log(name);

	/*   when doing assignment, (non-strict mode)
		 js will search local scope -> file scope -> global
		 if not found in global, js will create such var in global
	*/
	// Referebce error, not defined error. if strict mode is enabled
	g = 'g'; // implicitly create global variable, if not use var
	console.log(g);
}

// // why not use global a lot?
// // 1. not safe
// // 2. may be changed by others
// g = 'gg';
// console.log(g);

hello();
// console.log(l); wrong scope
// in nodejs, global scope is global, type: object
// in browser, global scope is window
console.log(global.g); // accessing a property that is not defined will return undefined

console.log(global.console === console); // true

// IIFE: Immediately Invoked Function Expression: one-time function
// self-invoke function (use ())
(function iife(arg) {
	console.log('iife', arg);
})('params');  // ()() first return a function / undefined


// add ;, otherwise (intermediate value)(...) is not a function
(function iife() {
	console.log('iife');
})();

// ReferenceError: iife is not defined
// iife();

// hoisting: js will move variable declarations 
//           to top of the CURRENT scope 
console.log(h);
var h = 'h';

// function name is optional,
// but by convention, we add the func name
// hi is visiable, hi is only available in memory and invisible
var hi = function hi() {};  // avoid hoisting, use same name 

// console.log(sayHi());
function sayHi() {
	console.log('say hi');
}
sayHi(); // say Hi undefined ----hoisting + overwrite

function sayHi(name) {
	console.log('say Hi', name);
};
sayHi('Bob'); // say Hi Bob


// NaN: not a number
var price = '$10', // '10' -> 10 is ok
	count = 5,     // undefined count will result in getting a NaN
	total = price * count;  // NaN

console.log(total); // NaN
console.log(total === NaN);  	  // false
console.log(total === NaN);       // false
console.log(NaN === NaN);    	  // false, it's a standard
console.log(typeof NaN);		  // number
console.log(Number.isNaN(total)); // true
















