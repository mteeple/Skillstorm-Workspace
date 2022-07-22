let fruits = ['Apple','Orange', 'Cherry', 'Mango','Pineapple']

//Add items to the end of an array
fruits.push('Pear');
console.log(fruits);
fruits.pop(); //removes last item of an array
console.log(fruits);

//Add items to the front of an array
fruits.unshift('Canteloupe');
console.log(fruits);

//Remove item from the front of an array
fruits.shift();
console.log(fruits);

//Finding a specific item in an array
let cherryIndex = fruits.indexOf('Cherry');
console.log(cherryIndex);

//Removing an item at an index
let removedFruits = fruits.splice(cherryIndex, 1); //Splice works similary to substring
console.log(fruits);
console.log(removedFruits);

//Cloning an array. The return value is a new location in memory
let fruitsCopy = fruits.slice();
fruitsCopy.pop();
console.log('Original ' + fruits);
console.log('Copy ' + fruitsCopy);
