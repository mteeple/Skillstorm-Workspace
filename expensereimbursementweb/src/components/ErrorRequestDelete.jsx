import axios from "axios";
import React from "react";

export const ErrorRequestDelete = ({ er }) => {
    const handleDelete = async (event) => {
        try {
            event.preventDefault();
            await axios.delete('http://localhost:8080/expensereimbursement/request',{data: {eID: er.expenseId}})
            window.location.reload(false);
        } catch (err) {
            console.log(err);
        }
    }
    return(
        <tr>
            <td className="tD">{er.employeeName}</td>
            <td className="tD">{er.expenseReason}</td>
            <td className="tD">{er.expenseNotes}</td>
            <td className="tD">{er.status.reimburStatus}</td>           
            <button onClick={handleDelete}>Delete</button>
        </tr> 
    );
}