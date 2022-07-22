/*
*  Javascript data types are implicit, but they are still important
*  Primitives:
*  -number 
*  -boolean
*  -string (char is same as string)
*  -null
*  -undefined
*  -BigInt (bigger than long)
*  -Symbol (Used by JS to give a signal to the compiler that something possesses some attribute)
*
*  Objects:
*  -Objects
*  -Arrays
*  -Functions
*/

let someVar = 100;
console.log(typeof someVar); //What is the type of the variable. Returns as a string 'number'

someVar = false;
console.log(typeof someVar); //boolean

someVar= [1,2,3];
console.log(typeof someVar); //object cannot be nulled (due to backwards compatability from older versions)

console.log(typeof function(){}); // function
