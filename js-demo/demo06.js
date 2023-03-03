// js is single threaded

// it will invoke your function at a later time
// param1: callback function (a function registered but invoked at a later time)
// param2: timeout in milliseconds
var myTimeout = setTimeout(function delay() {
	console.log('timed out');
}, 2000);
console.log('after setTimeout');

/*
    Event loop is talking about how js executes asynchronous operations
    Whenever seeing async operations such as setTimeout, it will be moved
    to Web APIs, once the function is timed out in Web APIs, the callback
    will be moved to Queue. js will continue to execute rest of the sync
    operations. When Stack is empty, js starts to move functions from Queue
    to Stack for execution.
    ** All the async functions will be executed after sync functions
*/

// param1: callback function (a function registered but invoked at a later time)
// param2: interval in milliseconds
var myInterval = setInterval(function interval() {
	console.log(new Date());
}, 1000);

// functions in global
clearTimeout(myTimeout);
clearInterval(myInterval);

// 3 tiers:. What Why When

// use setTimeout to implement customInterval
function customInterval(ca, interval) {

}

// bonus: how to stop a specific customInterval?
customInterval(function() {
	console.log(new Date());
}, 1000);
customInterval(function() {
	console.log(new Date());
}, 1000);












