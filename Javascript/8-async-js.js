//setTimeout takes two params
// 1. A function to be executed at a later point in time (Callback Function)
// 2. A number representing the amount of milliseconds to wait before invoking the callback

setTimeout(() =>{
    console.log('Callback invoked')
},5000);

//while(true){

//}//This while true loop will never exit the call stack, therefore prevents the 'callback invoked'

// setInterval is the same as setTimeout, but will run the function each time the passed time elapses
// It's a recurring setTimeout
let count = 0;
let intervalId = setInterval(() =>{
    console.log(count++);
    if (count>10){
        clearInterval(intervalId)
    }
    //console.log(new Date());

}, 500);