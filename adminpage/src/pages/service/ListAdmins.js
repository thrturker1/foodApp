import React, { useState, useEffect } from 'react'
import Header from '../components/Header';
import LeftMenu from '../components/LeftMenu';
import axios from 'axios'

export default function ListAdmins() {
    const [admins, setAdmins] = useState([]);
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [statue, setStatue] = useState('');

    useEffect(() => {
        axios.get('http://localhost:8080/api/admins/getAll')
            .then(res => setAdmins(res.data))
            .catch(console.error())
    }, [])

    const postAdmin = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/admins',{
            firstName,
            lastName,
            email,
            statue
        }).then(res => console.log('Posting Admin',res)).catch(err => console.log(err))
        window.location.reload(false);
    }

    const postDelete = (id,e) => {
        e.preventDefault();
        axios.delete(`http://localhost:8080/api/admins/${id}`,{
            firstName,
            lastName,
            email,
            statue
        }).then(res => console.log('Delete Admin',res)).catch(err => console.log(err))
        window.location.reload(false);
    }


    const arr = admins.map((admins,index) => {
        return (
            <tr>
                <td style = {{border : '1px solid red'}}>{admins.id}</td>
                <td style = {{border : '1px solid red'}}>{admins.firstName}</td>
                <td style = {{border : '1px solid red'}}>{admins.lastName}</td>            
                <td style = {{border : '1px solid red'}}>{admins.email}</td>
                <td style = {{border : '1px solid red'}}>{admins.statue}</td>
                <td style = {{border : '1px solid red'}}><button onClick = {(e) => postDelete(admins.id, e)}>delete</button></td>
            </tr>
        )
    }) 
    return (
        <div>

            <Header />
            <LeftMenu />
            
            <table style = {{border :'2px solid red', marginTop: '10px',marginLeft : '380px'}}>
                <th style = {{border : '1px solid red'}}>ID</th>
                <th style = {{border : '1px solid red'}}>İsim</th>
                <th style = {{border : '1px solid red'}}>Soyisim</th>
                <th style = {{border : '1px solid red'}}>Email</th>
                <th style = {{border : '1px solid red'}}>Statü</th>
                <tr>
                    <td style = {{border : '1px solid red'}}>Admin ID</td>
                    <td style = {{border : '1px solid red'}}><input type = 'text' value = {firstName} onChange = {(e) => setFirstName(e.target.value)}></input></td>
                    <td style = {{border : '1px solid red'}}><input type = 'text' value = {lastName} onChange = {(e) => setLastName(e.target.value)}></input></td>
                    <td style = {{border : '1px solid red'}}><input type = 'text' value = {email} onChange = {(e) => setEmail(e.target.value)}></input></td>
                    <td style = {{border : '1px solid red'}}><input type = 'text' value = {statue} onChange = {(e) => setStatue(e.target.value)}></input></td>
                    <td style = {{border : '1px solid red'}}><button onClick={postAdmin} >send</button></td>
                </tr>
                {arr}
            </table>
        </div>
    )
}


