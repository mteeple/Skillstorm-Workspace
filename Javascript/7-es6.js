//Spread operator
//Spreads an iterable object out over one entity

const nums = [1,2,3,4,5,6,7,8];
console.log(...nums); //Super concise syntax for above, Works with infinite sized array. Iterates over all of them.

//Objects are not iterable, BUT spread operator makes an exception for objects
const obj ={
    num:10,
    color: 'blue'
}
console.log(obj);
//creates a clone of the old object. Different locations in memory.
const newObj={ 
    color: 'Green', //gets overwritten by Blue from obj
    ...obj,
    anotherProp: 'someProp', // appends it to the end
    color: 'Green' // changes the color to Green
}
console.log(newObj);

//Append an item to an array using spread
const newNums=[...nums, 9];
console.log(newNums);
console.log(nums);

const string = 'Hello World';
//obtain a char array of the string
const charArray = [...string];
console.log(charArray);

//Rest operator
//Rest condenses multiple values into a singular array. (Varargs from Java)

function printMovies(movie1, movie2, movie3, ...movies){
    console.log('The number 1 movie is: ', movie1);
    console.log('The number 2 movie is: ' + movie2);
    console.log(`The number 3 movie is: ${movie3}`);
    console.log(movies);
}
printMovies('Star Wars', 'Lord of the Rings', 'Harry Potter', 'The Godfather');

//Arrow functions
//Similar to lambda functions in JAVA

//This is the most common way to define a function in JS 
const someFn = () => {
    console.log(num);
}
/**
 * Ground rules for arrow functions
 * 
 * () are required when 0 parameters exist OR 2+ parameters exist
 * () are optional if there's only 1 parameter
 * {} are optional if there's only one line of code for the function
 * if there's no {}, whatever is returned by that one line, is returned from the function
 * if there's no {}, you also cant type return
 * if there's zero or two+ lines, the {} are required
 * if there's {}, to return, you MUST type return
 */
// Arrow functions are super concise
const addTwoNums = (x,y) => x+y;

console.log(addTwoNums(1,2));

const printXThenAddTwoNums = (x,y) =>{
    console.log(x);
    return addTwoNums(x,y); // have to have return here or it will be undefined.
}
console.log(printXThenAddTwoNums(5,6));

//Object Destructuring
//This allows us to extract certain properties from an object
const sally ={
    fullName:{
        firstName: 'Sally',
        lastName: 'Smith'
    },
    age: 27,
    favColor: 'Red',
    hobbies: ['Skiing', 'Cooking','Hiking', 'Surfing'],
    favFood: 'Lasanga'
}

//Destructuring properties is like defining a new variable
//Instead of this
let sallyAge = sally.age;

//We can do this instead
let {age, fullName, hobbies} = sally;
console.log(sally);
console.log(age,fullName,hobbies);

//Alternatively, you can use it to expect certain parameters in a function cell
//This also gets around the ordering of the items in a cell
const printPerson = ({age, fullName})=> {
    console.log(fullName.firstName + ' is ' + age + ' years old');
}
const printsPerson = (person)=> { // This is a bit longer and harder to read in some ways
    console.log(person.fullName.firstName + ' is ' + person.age + ' years old');
}
printPerson(sally);
printsPerson(sally); // runs 2nd vers

//Array Destructuring
//Array destructuring order DOES matter
const numbers = [67,234,-235,6];
const [num1,num2]=numbers; // can put empty comma's in front to push back which variable is being seen
console.log(num1,num2);