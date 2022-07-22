import { useState,  useEffect } from 'react';
import axios from 'axios';
import { ErrorRequestPending } from './ErrorRequestPending';
import { ErrorRequestDelete } from './ErrorRequestDelete';

export const ErrorRequestHandler = () => {
    const [expreq, setExpreq] = useState([]);
    useEffect(()=>{
        axios.get('http://localhost:8080/expensereimbursement/request')
            .then(res => setExpreq(res.data));
    },[]);
    return(
        <>
            <table className='tables'>
                <thead className='tHeader'>
                    <tr>
                        <th className='tH'>Employee Name</th>
                        <th className='tH'>Reason</th>
                        <th className='tH'>Notes</th>
                        <th className='tH'>Request Status</th>
                    </tr>                  
                </thead>
                <tbody>                 
                    {expreq && expreq.map( er  => {
                       if (er.status.statusId === 1){
                            return <ErrorRequestPending key = {er.expenseId} er = { er }/>;                   
                       }
                    })}
                </tbody>
                <tbody>
                    {expreq && expreq.map( er  => {
                       if (er.status.statusId === 2){
                            return <ErrorRequestDelete key = {er.expenseId} er = { er } />;                   
                       }
                    })}
                </tbody>
                <br/>
                <tbody> 
                    {expreq && expreq.map( er  => {
                       if (er.status.statusId === 3){
                            return <ErrorRequestDelete key = {er.expenseId} er = { er } />;                   
                       }
                    })}
                </tbody>
            </table>
        </>
    );
}