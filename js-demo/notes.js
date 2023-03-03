/*  1. We use parenthesis to invoke a function/method (field == property)
	2. We use dot notation to accessa property
	
	prefer '' (golow convention)
	backe slash \', escape \
	semicolon: optional, recommended adding {}
	console.log() can take many parameters
*/ 

//  ES5 js primitive types

//	1. String
// type: string, value: hi string
// typeof: a operator, take 1 parameter

// 2. boolean:  true/false

// 3. number

// 4. null : type and value are both null, it means nothing / has no value
// in fact, typeof null returns object is considered a bug in js

// 5. undefined: type and value are both null, it means nothing / has no value



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

// do not use == to compare in JS 
// ***difference: == & ===
// ===: it will compare both value and type
// ==: only compares value


// if else
// 0: false, 2: true, 
// '': false, '0': true, 
// []、[0]: true 
// null: false

// 6 falsy values in JS: 
// false,   0,   '',   null,   undefined,   NaN(not a num)