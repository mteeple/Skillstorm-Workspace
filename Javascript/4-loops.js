// while
//for
//do-while
//enhanced for loop (for..of) && (for..in)

//while smth is not empty best use
let counter=0;
while (counter<5){
    console.log(counter++);
}

//for loop
for(let i =0; i<10; i++){
    console.log(i);
}
//do-while
do{
    console.log('This loop only runs once');
}while(false)

//for..of
//for..of iterates over "iterable" objects (It possesses Symbol.iterator on it)
//In JS, arrays are "iterable"
const nums = [-6, 52, 632];

//for (int num: nums){ JAVA "enchanced for loop"
//    
//}
for (let num of nums){
    console.log(num);
}

//strings are also iterable
for(let char of 'Hello World'){
    console.log(char);
}

//for..in
//for..in itereates over "enumerable" entities
for(let num in nums){ // The indices are the enumerable bits 
    console.log(num); // prints 0 1 2
}

//Objects properties are "enumerable" by default

//Defining an object
const john= {
    firstName:'John',
    lastName: 'Doe',
    age: 35,
    favColor: 'Green',
    hobbies: ['Golfing', 'Fishing', 'Mountain Biking','Netflix']
};
console.log(john);
console.log(john.firstName); // Accessing a value off an object

//Can set properties to be enumerable
Object.defineProperty(john, 'firstName', {enumerable:false}); // This just removes firstName from the for loop

//print all of the keys of an object
for(let key in john){
    console.log(key);
    //console.log(john[key]); Square bracket notation is used for dynamic keys
}

let id = 10; 
const obj = {
    [id]:1 //dynamic key. Use the value of the variable id as the key
}
console.log(obj);