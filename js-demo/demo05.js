/* ******* prototype
	every function has a prototype property points to an object
	every object has a __proto__ property points to its constructor fn.prototype
	__proto__: dunder proto
*/

function getValue() {
	return this.value;
}
function A() {
	this.value = 10;
	this.getValue = getValue;
}
// getValue = 123;
var a1 = new A(),
	a2 = new A();

console.log(
	a1 === a2,                          // false
	a1.value === a2.value,				// true
	a1.getValue() === a2.getValue(),    // true
	a1.getValue === a2.getValue         // false, two function declarations, different address in mempry / true, 123
);


function B() {
	this.value = 20;
}
B.prototype.getValue = function getValue() {
	return this.value;
}

var b1 = new B(),
	b2 = new B();

console.log(b1);  // {value: 20}
console.log(b1.getValue());  // 20
console.log(B.value); // undefined

Object.prototype.abc = 123;
console.log(b1.abc);

// inheirtance
function Parent() {
	this.x = 1;
}
Parent.prototype.y = 2;

function Child() {
	this.z = 3;
}
Child.prototype = new Parent();

var child = new Child();
console.log(child.x, child.y, child.z);

// console.log(p.constructor);     // Parent
// console.log(child.constructor); // Parent (incorrect, should be Child)

/* ultimate way to do ES5 inheritance
	Object.create();
	1. let child.prototype equal to parent.prototype with Object.create
	2. simulate super, ( P.apply(this) )
	3. fixing child constructor pointer
*/

function P() {
	this.x = 10;
}
P.prototype.y = 20;

function C() {
	// super()
	P.call(this);
	this.z = 30;
}

C.prototype = Object.create(P.prototype);
C.prototype.constructor = C;    // constructor reset

var c = new C();
console.log(c.x, c.y, c.z); // 10 20 30
console.log(c.constructor); // C

// all check inheritance; relationship: prototype chain / is a
console.log('is P.prototype on c\'s prototype chain:', P.prototype.isPrototypeOf(c));
console.log(c instanceof P);

console.log(c.hasOwnProperty('y'));






