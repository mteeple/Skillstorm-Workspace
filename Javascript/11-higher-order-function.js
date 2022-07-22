/**
 * Higher Order Functions (HOFs)
 * 
 * These are functions that EITHER take a function as a parameter OR return a function
 */

//Callback functions passed to higher order functions

//Write a function that returns another function
const timeX = (x) => {
    //This is a closure
    //A closure is when an inner scope maintains reference to an outer scope
    return (y) => {
        return x*y
    }
}
const times5 = timeX(5);
console.log(times5(10));
console.log(times5(-1));

const times3 = timeX(3);
console.log(times3(3)); //uses times3
console.log(times5(5));
console.log(timeX(10)(2)); //goes straight to timeX

/**
 * Passing a function to another function
 * 
 * Array Built-in HOFs
 * 
 * For all of these, mutating the value does NOT mutate the array. they are pure functions
 * 
 * forEach - Allows me to run some function on each element of the array.Whatever is returned is ignored
 * map - The exact same as forEach, but whatever is returned is added to a NEW array and that is returned
 * filter - Filter also returns a new array, but it only returns the indices where true is returned
 * reduce - Takes an arary and reducies it to a singular value. It does this by running some accumulated value
 */

//forEach
const planets = ['Mercury','Venus','Earth','Mars','Saturn','Jupiter','Uranus','Neptune','Pluto'];

function printPlanet (planet){
    console.log(planet);
}
//forEach has a loop that loops over planets and calls printPlanet with each planet
//What forEach does
//for(let planet of planets){
//    printPlanet(planet);
//}
planets.forEach((planet) =>{
    planet = 'EARTH';
    return planet;
}); 

//The planets array is not changed
console.log(planets);


//MAPS
const updatedPlanets = planets.map((planet) =>{
    planet = 'EARTH';
    return planet;
}); 
const upperCasedPlanets = planets.map(planet => planet.toUpperCase());

console.log(planets); //same old array
console.log(updatedPlanets);//now all EARTH
console.log(upperCasedPlanets); // back to old array and updating them all to be uppercase


//FILTER
//Return only the planets that have an E in it
const planetsWithAnE = planets.filter(planet =>{
    return planet.includes('e') || planet.includes('E');
});
console.log(planetsWithAnE);


//REDUCE
//CurrSum will look like 0 -6 -11 - 20 - 23 -24. Return 24
const nums = [6,5,9,3,1]; //24
const sum = nums.reduce((currSum, num) =>{
    return currSum + num;
}, 0); //Starting with currSum at 0 (optional)

console.log(sum);

//find max
const maxNum = nums.reduce((currMax, num) =>{
    return currMax > num ? currMax : num;
}, Number.MIN_VALUE); // Smallest number possible
console.log(maxNum); //Will return 9 as it's the highest number in the array