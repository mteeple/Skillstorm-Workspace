import axios from 'axios';
import { useRef } from 'react';

export const SubmissionTable = () =>{
    const nameRef = useRef();
    const reasonRef = useRef();
    const noteRef = useRef();
    
    const handleSubmit = async (event) => {
        try {
            event.preventDefault();
            await axios.post('http://localhost:8080/expensereimbursement/request',
                {
                    employeeName: nameRef.current.value,
                    expenseReason: reasonRef.current.value,
                    expenseNotes: noteRef.current.value
                }
            );           
            nameRef.current.value = '';
            reasonRef.current.value = '';
            noteRef.current.value = '';
        } catch (err) {
            console.error(err);
        }
    }

    return(
            <form onSubmit={handleSubmit}>
                <div>
                    <h1>Reimbursement Submission</h1>
                    <input name = 'employeeName' ref = {nameRef} placeholder='Enter Name'/>
                    <br/>
                    <br/>
                    <input name = 'expenseReason' ref = {reasonRef} placeholder='Enter Reason'/>
                    <br/>
                    <br/>
                    <input name = 'expenseNotes' ref = {noteRef} placeholder='Enter Notes'/>
                    <br/>
                    <button>Submit</button>
                </div>
            </form>
    );
}