import axios from "axios";

export const ErrorRequestPending = ({ er }) => {
    const handleApprove = async (event) => {
        try {
            event.preventDefault();
            await axios.put('http://localhost:8080/expensereimbursement/request',{eID: er.expenseId, rID: 2})
            window.location.reload(false);
        } catch (err) {
            console.error(err);
        }
    }
    const handleDeny = async (event) => {  
        try {
            event.preventDefault();
            await axios.put('http://localhost:8080/expensereimbursement/request',{eID: er.expenseId, rID: 3})
            window.location.reload(false);
        } catch (err) {
            console.error(err);
        }
    }
    return(
        <tr>
            <td className="tD">{er.employeeName}</td>
            <td className="tD">{er.expenseReason}</td>
            <td className="tD">{er.expenseNotes}</td>
            <td className="tD">{er.status.reimburStatus}</td>
            <button onClick={handleApprove}>Approve</button>
            <button onClick={handleDeny}>Deny</button>
        </tr>  
    );
}