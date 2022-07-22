//Classes added in javascript in 2015 (ES6)
//They are an abstraction over "constructor functions" or "syntactic sugar" over constructor functions

class Shape{

    color; // This defines color as a property of Shape   
    
    //Writing a constructor (no overloading so one constructor per class)
    constructor(color){
        //super(); is implicitly called if not specified - Have to extends Object 
        this.color= color;
    }
    //Adding methods to our Shape class
    static someFn(){
        console.log("Hello Shape!");
    }

    printColor(){
        console.log(this.color);
    }

    //Adding functions to the shape object
}

const shape = new Shape('Red');
console.log(shape.color);

Shape.someFn();
shape.printColor();

//Inheritance with Classes
//All properties will be inherited from Shape (and Object)
class Rectangle extends Shape{
    length;
    width;

    constructor(length, width, color='Red'){
        super(color);
        this.length = length;
        this.width = width;
    }
    calcArea(){
        return this.length * this.width;
    }
    calcPerimeter(){
        return (2 * this.length) + (2 * this.width);
    }
}
const redRectangle = new Rectangle(10.0, 5.5);
console.log(redRectangle);
console.log(redRectangle.calcArea());
console.log(redRectangle.calcPerimeter());