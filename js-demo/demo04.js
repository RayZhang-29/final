/*  ********
	Closure is talking about function inside another function.
	When outer function is executed, js will create a closure object 
	to store all the outer function's local vatiables being referenced
	in the returned inner function.

	pro: avoid creating a global variable, to create a private variable
	cons: memory leak may happen
*/

function outer() {
	var x = 1,
		y = 2;
	function inner() {
		console.log(y);
	}
	return inner;
}

var myInner = outer();
myInner = outer();  // how many closures will be created? 2
myInner();

// var count = 0;  // shared
function counterFactory() {
	var count = 0;
	return {
		getCount: function getCount() {
			return count;
		},
		setCount: function serCount(c) {
			count = c;
		}
	}; // object literal {} --> new object
}

var counter1 = counterFactory(),
	counter2 = counterFactory();

counter1.setCount(5);
console.log(counter1.getCount(), counter2.getCount()); // not equal, two closures

console.log(counter1 === counter2);



// implement
function increaseFactory() {
	var count = 0;
	return function increaseOne() {
		count += 1;
		console.log(count);
	};
}

var myIncrease = increaseFactory();
// console.log(myIncrease);
myIncrease(); // 1
myIncrease(); // 2
myIncrease(); // 3



// exam q, tip: work as a js engine.
// scan and hoisting, execute line by line
function MyClass() {
    this.x = 100;
    var y = 'abc';
    var getX = function() {
        console.log(this.x); // no caller, this => global
        console.log(y);      // function scope
    };
    getX();
    this.getY = function() {
        console.log(this.x);
        console.log(y);
    };
}
var myClass = new MyClass();  // (1)
myClass.getY();				  // (2)

// output:
// undefined, abc
// 100, abc

// Analysis:
// In (1), we first declare the 'myClass' function and assign it with the result of 'new MyClass()'.
// When we use new to call the MyClass() constructor, the following will be executed:
// 1. create a new empty object
// 2. set x of the new object to 100
// 3. declare y and assign 'abc' to it.
// 4. declare local function getX
// 5. invoke getX() function, and log 'undefined' for this.x because this is the getX function object, 
//    not the new created object. Also, log y, which is a local variable 'abc'.
// 6. For this.getY, this is the new object (myClass) and assign myClass.getY with a new function.
// In (2), the getY() funtion logs this.x = myClass.x = 100 and local variable y = 'abc'.












