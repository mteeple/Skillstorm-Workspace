import {useState, useEffect, useRef}from 'react'
import axios from 'axios'
import { SoftwareDeveloper } from './SoftwareDeveloper';

export const SoftwareDeveloperList = () => {
    const [devs, setDevs] = useState([]);
    const [name, setName] = useState('');
    const titleRef = useRef(); //creates a reference object
    const salaryRef = useRef();

    /**
     * useRef hook:
     * 
     * useRef returns a reference object that WILL persist between re-renders similar to useState
     * Key difference is that updating a ref, does NOT trigger a re-render
     * 1. Refs are mutable and I can update them without a setter
     * 2. Mutating a ref does NOT cause a re-render
     * 3. The value is persisted between re-renders
     * 
     * I can also use the ref to refer to a native HTML element (similar to document.getElementById)- alternative to it
     */
    
    useEffect(() =>{
        axios.get('https://my-json-server.typicode.com/skillstorm-walsh/employees-v1/employees')
            .then(res => setDevs(res.data));
    },[]); //Be sure this is an empty array

    
    const handleSubmit= async (event) => {
        try{
            event.preventDefault(); // prevent the default HTML form submission(AKA Reload the page)
            // 1. Extract the data
            // 2. Send out a POST request
            // 3. When you receive the newly created dev id, add it to the dev array
            const {data}  = await axios.post('https://my-json-server.typicode.com/skillstorm-walsh/employees-v1/employees',
                { 
                    name, //implied that it's name: name because they have same name
                    title: titleRef.current.value, // think of titleRef.current as <input />
                    salary: salaryRef.current.value
                }
            );
            console.log(data)
            setDevs([...devs, data]); // (reminder ... implies spread, spread over an array)
            setName('');
            titleRef.current.value= null;
            salaryRef.current.value =''; //both null and empty string work
        }catch(err){
            console.error(err)
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <table>
                <thead>
                    <tr>
                        <th> Name </th>
                        <th> Title</th>
                        <th> Salary</th>
                    </tr>
                </thead>
                <tbody>
                    {/* I want to dyanmically render all of those devs that I received */}
                    {/* <tr> This is the HTML way. Manual Typing
                        <td>Dan Pickles</td>
                        <td>Senior Technical Architect</td>
                        <td>100000</td>
                    </tr>                 */}
                    {/* Use the built in array method, map() to */}
                    {devs.map((dev) =>{
                        //Map constructs a new array based off what we return
                        return(
                            //Always use the primary id from the database since it's unique(now in softwaredeveloper.jsx)
                            <SoftwareDeveloper key ={dev.id} dev={dev} developers={devs} setDevs={setDevs}/>

                        )
                    })}
                    <tr >
                        {/* In react, we should not USE document.getElementById to get access to a DOM element
                            Doing so, bypasses React and all of its optimization, instead, we should do this React's way.
                        */}
                        {/* This is a controlled component. React is in charge of it */}
                        <td><input name = "Name" value ={name} onChange={(event) => setName(event.target.value)} placeholder='Please enter Name'/></td>
                        {/* Default is an uncontrolled component. React doesn't manage it, it just uses native DOM
                            to manage state
                        */}
                        {/* When input updates, my ref will also update since it "points" to that input */}
                        <td><input name = "Title" ref={titleRef} placeholder='Please enter Title'/></td>
                        <td><input name = "Salary" ref={salaryRef} placeholder='Please enter Salary'/></td>
                        <button>Create new Developer</button>
                    </tr>
                </tbody>
            </table>
        </form>
        // <>
        //     <h3>Software Dev List</h3>
        // </>
    );
}
