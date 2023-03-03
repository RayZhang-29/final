// 'use strict';

// object
// {key: value}, function, Date, / abc /...

// 1. {}, object literal
var s1 = {};

/*  js object is key/value pair
	type of key is a string, value can be anything
	we can omit the quotes on key if it doesn't contain special characters
	($, _ can be used in variables, others not)
	(can not start with numbers)
*/
s1 = {
	name: 'Alice',  // name is still a string 
	hi: function hi() {
		// hi Alice
		console.log('hi', this.name);
	},
	'my name': 'bob'
};
s1.hi();

// [] square bracket notation
console.log(s1['my name']);
var specialName = 'my name';
console.log(s1[specialName]);

// update
s1.name = 'bob';

// create
s1.age = 12;
// s1['age'] = 12;

// delete
delete s1['my name'];

// s1.toString()
console.log(s1);

/*  1st param: object to be modified
	2nd param: a string representing a property
	3rd param: a config object
*/

// Property descriptors present in objects come in two main flavors: data descriptors and accessor descriptors. 
// A data descriptor is a property with a value that may or may not be writable. 
// An accessor descriptor is a property described by a getter-setter pair of functions. 
// A descriptor must be one of these two flavors; it cannot be both.

// 1. enumerable: true if and only if this property shows up 
// during enumeration of the properties on the corresponding object. Defaults to false.

// 2. configurable
// when this is set to false,
// the type of this property cannot be changed between data property and accessor property, and
// the property may not be deleted, and
// other attributes of its descriptor cannot be changed (however, if it's a data descriptor with writable: true, the value can be changed, and writable can be changed to false).
// Defaults to false.

// 3. writable: 
// true if the value associated with the property 
// may be changed with an assignment operator. Defaults to false.

// 4. value:
// The value associated with the property. Can be any valid 
// JavaScript value (number, object, function, etc.). Defaults to undefined.

Object.defineProperty(s1, 'gender', {
	value: 'male',
	enumerable: true,   // default false
						// in browser, show darken gender, not hidden
	writable: false,  	// default false, not read-only anymore
	configurable: true  // default false, can only configure once
});

Object.defineProperty(s1, 'gender', {
	value: 'male',
	enumerable: true,   // default false  ??? purpose ???
						// in browser, show darken gender, not hidden
	writable: true  	// default false, not read-only anymore
});

// if use strict mode, 
// TypeError: Cannot assign to read only property 'gender' of object '#<Object>'
s1.gender = 'female'; 

console.log(s1.gender);
console.log(s1);


// loop through object properties
var keys = Object.keys(s1);
for (var i = 0; i < keys.length; i ++ ) {
	var key = keys[i];
	console.log(key + ': ' + s1[key]);  // s1.key -> undefined
}

// for in loop, syntax sugar of above code
for(var key in s1) {
	console.log(key + ': ' + s1[key]); 
}


// getter and setter
var s1 = {
	name: 'charlie'
};

(function() {
	// address
	var value;
	Object.defineProperty(s1, 'addr', {
		// cannot specify value when getter and setter are present

		// getter will be called aytomatically when accessing the property
		get: function get() {
			console.log('in getter');
			// return this.addr; // stack overflow
			// return value; // global/file scope variables, not good
			// return this._addr;
			return value;
		},

		// setter will be called automatically when updating the property
		set: function set(addr) {
			console.log('in setter');
			// this.addr = addr; // stack overflow
			// this._addr = addr;
			value = addr;
		}
	});
})();

s1.addr = 'Princeton';
console.log(s1.addr);

// var s1 = {
// 	get addr() {},
// 	set addr(addr) {}
// };



// 2. new 
// every js function can be used to simulate the constructor function
// PascalCase  (camelCase)
// function Student(name, hi) {
// 	// name, hi: func
// 	this.name = name;
// 	this.hi = function hi() {
// 		console.log('hi', this.name);  // if use name, may be wrong after modification, use this.name.
// 	};
// }

// var student = new Student('alice');
// student.name = 'bob';
// student.hi();

// // Object.preventExtensions, Object.seal, Object.freeze
// var obj = {}



function Person(name) {
	if ('string' === typeof(name)) {
		this.name = name;
	}
}

function Student(name, score) {
	Person.apply(this);
	Object.defineProperty(this, 'score', {
		value: score,
		writable: false
	});
}

Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;

Student.prototype.sayHello = function sayHello(name, score) {
	console.log(name, score);
}

var p = new Person('Ray');
var s = new Student('Ray', 79);

s.sayHello('Ray', 79);
console.log(s.score);





const products = {
  0: {name: 'Aspire E 15', unit_price: 600, sale_count: 20},
  1: {name: 'Aspire E 16', unit_price: 500, sale_count: 10},
  2: {name: 'Aspire E 17', unit_price: 600, sale_count: 0},
  3: {name: 'Aspire E 18', unit_price: 600, sale_count: NaN},
  4: {name: 'Dell XPS 12', unit_price: 400, sale_count: 80},
  length: 5
};

const totalProfits = Array.from(products)
  .filter(([key, value]) => value.name.toLowerCase().includes('aspire'))
  .reduce((acc, [key, value]) => {
    const sales = isNaN(value.sale_count) ? 0 : value.sale_count;
    const profit = (value.unit_price * sales);
    return acc + profit;
  }, 0);

console.log(totalProfits); // output: 17000








