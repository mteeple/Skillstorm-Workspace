// Promises are a nice way to deal with asynchronous operations
// Before Promises, we used callbacks (got really messy)

//Promises are objects that represent the eventual success or failure of an asynchronous operation

/**
 * Promises have different states that represent the current state of an asynchronous event
 * 
 * Pending: The request is still being processed (The buzzer sitting idle)
 * Fulfilled: The request has been processed and the desired outcome occurred (Buzzer flashes green. Table is ready)
 * Rejected: The request has been processed and the undesired outcome occurred (Buzzer flashes red, no tables)
 * Settled: The request has been processed and either outcome has been executed (Buzzer is returned)
 */

//Create a Promise
//Using the Promise constructor
const createPromise = (num)=>{
    return new Promise((resolve, reject) =>{
        if (num<10){
            reject('Number can\'t be less than 10'); // The parameter to this function is the error data
        }
        else{
            resolve(`Number received! Your number is ${num}`); // the parameter to this function is the success data
        }
    });
};
const myPromise = createPromise(14); //This should return a successful promise

//handling a promise
console.log(myPromise); //Basic

// .then() handles a fulfilled promise
// .catch() handles rejected promise 
// Pretty much works like try-catch
myPromise.then(data =>{  
    //I put in here what I want to do with said data
    //publishDataToServer(data)
    console.log("Handling successful promise");
    console.log(data);
    throw "Promise was sucessful, but triggering .catch()"; //Promise.reject(msg - Triggers the error from catch)
}).catch(err => console.error(err));

//Chaining Promises
// .then() AND .catch() both return promises implicitly 
//Anything returned is either a fulfilled Promise
//Anything thrown in either is a rejected Promise

//Create a Promise that always is immediately fulfilled
Promise.resolve(1)
    .then(num => num +1) // Returns 2 as a new fulfilled promise. Return Promise.resolve(num+1)
    .then(num => {console.log(num); throw num + 1}) //Rejects promise with throw
    .then(num => {console.log(num); return num + 10}) // This one gets skipped due to rejected promise
    .catch(num => console.log(num))
    .finally(()=> console.log("Finally done!"));

//Handle multiple Promises concurrently 
//I'll emulate a network request by adding a time element to it

const createTimedPromise = (time, promiseName) =>{
    return new Promise((resolve, reject) => {
        setTimeout(()=>{
            if(promiseName === "Short Promise"){
                reject(`${promiseName} was rejected!`)
            }
            resolve(`${promiseName} was fulfilled`);
        }, time);
    });
}
const shortPromise = createTimedPromise(3000, 'Short Promise');
const mediumPromise = createTimedPromise(5000, 'Medium Promise');
const longPromise = createTimedPromise(7000, 'Long Promise');

//They succeed or fail together
Promise.all([shortPromise, mediumPromise,longPromise]) // if any of them were set to 0, they would all immediately fail
    .then(data => console.log(data))
    .catch(err=> console.log(err));
//Used to wait for the first succes of ANY of the promises involved
Promise.any([shortPromise, mediumPromise,longPromise])
    .then(data => console.log(data))
    .catch(err=> console.log(err));
//Used to wait for the first success OR failure of ANY of the provided promises
Promise.race([shortPromise, mediumPromise,longPromise])
    .then(data => console.log(data))
    .catch(err=> console.log(err));
//Used to wait for all promises provided REGARDLESS of outcome
Promise.allSettled([shortPromise, mediumPromise,longPromise])
    .then(data => console.log(data))
    .catch(err=> console.log(err));