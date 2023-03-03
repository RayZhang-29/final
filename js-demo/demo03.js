/*  ***** this: key word
	in non-strict mode:
		for a constructor function, this binds to the newly created object
		for non-constructor functions, if there is a caller, this binds to the caller;
		if there is no caller, this binds to global.

	in strict mode:
		everything else is the same except that if no caller, this is undefined	
	

*/

function Vehicle(brand) {
	this.brand = brand;
	// var mileage = 12; just create a function-scope variable

	// return this; will happen when new Vehicle (invisible)
	// return; will happen when calling Vehicle directly. undefined will be returned
}

/*  What happened when we new Vehivle?
	1. empty object creation
	2. * point this to the newly created object
	3. this.brand = 'BMW' => {}.brand = 'BMW' => {brand: 'BMW'}
	4. js will return this / newly created object
	5. v gets assigned this / newly created object
*/

// param: brand
var v = new Vehicle('BMW');
console.log(v);

// var vv = {brand: 'TTT'};
// console.log(vv);

var h = Vehicle('Chevy');
console.log(h); // undefined
console.log(global.brand === brand); // true

var alice = {
	name: 'alice',
	hi: function hi(prefix, suffix) {
		console.log('hi', prefix, this.name, suffix);
	}
}
alice.hi(); // hi alice

var myHi = alice.hi; // 
myHi(); // hi() -> hi alice

// can we change this binding?
console.log('------------- this binding change -------------')

// call
// 1st param: new binding for this
// list all args starting from sec param
myHi.call(alice, 'Mr.', 'Handsome');

// apply
// 1st param: new binding for this
// 2nd param: an array / array-like object containing params.
myHi.apply({name: 'Peter'}, ['Mr.', 'Handsome']);

// bind: it will rewturn a new function with this binding change
// 1st param: new binding for this
myHi.bind(alice)('Ms', 'Pretty');
myHi.bind(alice, 'Ms', 'Very Pretty')();
myHi.bind(alice, 'Ms')('Very Pretty');


var newMyHi = myHi.bind(alice, 1);
newMyHi(2);
newMyHi(3);

var order = {
	price: 100,
	calculate: function calculate() {
		return {
			getTotal: function getTotal(qty) {
				return this.price * qty;
			}
		};
	}
};

// find a way to invoke getTotal(5) and output 500
var tempObj = order.calculate();
console.log(tempObj.getTotal.call(order, 5));
console.log(tempObj.getTotal.apply(order, [5]));
console.log(tempObj.getTotal.bind(order)(5));


/* SOLID Principles
	O: open for extension, but closed for modification
*/

// (behivor question)
// deployment environments: 
//	local => develop => QA (->local) 
//  => UAT (UserAcceptanceTest) => production

// gold: 30%, silver: 20%, bronze: 10%, 
// VIP: 40% OFF

function checkout(price, member) {
	switch(member) {
		// open for extension? yes
		// closed for modification? no
		case 'gold':
			return price * .7;
		case 'silver':
			return price * .8;
		case 'bronze':
			return price * .9;
		default:
			return price;
	}
}
console.log(checkout(500, 'gold'));

// open for extension
var membership = {
	gold: 0.7,
	silver: 0.8,
	bronze: 0.9
};
// function is closed for modification
function checkout2(price, member) {
	return price * (membership[member] || 1);
}
console.log(checkout2(500, 'silver'));
console.log(checkout2(500, 'hacker'));


var membership2 = {
	gold: 0.6,
	silver: 0.7,
	bronze: 0.8
};
function checkout2(price, member) {
	return price * (this[member] || 1);
}

console.log(checkout2.call(membership2, 500, 'gold'));
console.log(checkout2.apply(membership2, [500, 'gold']));
console.log(checkout2.bind(membership2)(500, 'gold'));













