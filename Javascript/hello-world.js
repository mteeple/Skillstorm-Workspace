// var is hoisted to the top for its variables making them global (undefined if no value set)
//Code execution starts at the top of the file with Script languages
console.log('Hello World');

/*  Variables- 3 choices
*   var (bad) - 2 scopes - Global or Function scope (determined by usage), can be redeclared(int a=5, int a=6)=BAD
*   let (good) - Variable declared once, can be reassigned
*   const (good) - Block scoped. No redeclaration OR reassignment.
*/
var a='a';
var a='b';

let b = 'b'; //Global variable
if(true){
    let c = 'c'; //Only accessible within this statement - Block Scope
    var d = 'd'; //Global scope due to var
}
console.log(d);

//Const
const arr= [1,2,3];
arr[0] = 100;
console.log(arr);
