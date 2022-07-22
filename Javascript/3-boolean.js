// Two types of equality operators
// javascript just has Equality operator (==)
// Works by comparing the values between two entities

 console.log(''==''); //true
 console.log( 1==1); //true
 console.log(1==2); //false
 console.log(1=='1'); //true, because the values are the same (casting 1 to a string)

//Strict equality operator (===)
//Works by first comparing the type of the two, if true, compares the values

console.log(1 ==='1'); //false
console.log(1 !=='1');//true

//I only use == in one place 
//Great for comparing null and undefined. Good for checking to ensure a value is NEITHER null or Undefined
console.log(null == undefined); //true
let myVar = undefined;
if(myVar != null){
    //this prevent null/undefined values for myVar
    //this will not run
}

/**
 * Truthy vs Falsy values 
 * Falsy:
 *  - false
 *  - 0
 *  - -0 (negative 0)
 *  - 0n (BigInt zero)
 *  - null
 *  - undefined
 *  - '' (empty string value)
 *  - NaN
 *  
 * Truthy (Anythings that's not falsy)
 *  - true
 *  - 'false' (it's not actually false)
 *  - '0'
 *  - ' '
 *  - {}
 *  - []
 *  - 42 (any non zero number)
 */

//Casting to a boolean
// 1. Using Boolean wrapper class constructor
console.log(new Boolean(0)); //false
console.log(new Boolean('')); //false
console.log(new Boolean([])); //true

// 2. Implicit Casting with the ! operator
console.log(!0); //true
console.log(!!0); //false (You can use !! to change it to a boolean but keep it's false/true status)

// 3. Implicitly casted by context (ie. if condition)
if(0){
    console.log('This doesn\'t run');
}

let someVar = 0;
//There's technically a bug here
if(someVar){ // Use != null to allow 0 or '' or false
    console.log('The value of someVar is', someVar);
}