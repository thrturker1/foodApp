import React, { useState, useEffect } from 'react'
import Header from '../components/Header'
import LeftMenu from '../components/LeftMenu'
import axios from 'axios'
import { Grid } from '@mui/material';

export default function ListOrders() {
  const [orders, setOrders] = useState([]);
  const [customerName, setCustomerName] = useState('');
  const [productName, setProductName] = useState('');
  const [totalPrize, setTotalPrize] = useState();
  const [totalCount, setTotalCount] = useState();

  const [acceptedSuggests, setAcceptedSuggests] = useState([]);
  const [acceptedName, setAcceptedName] = useState('');
  const [acceptedAlergen, setAcceptedAlergen] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/api/orders/getAll')
      .then(res => setOrders(res.data))
      .catch(console.error())
  }, [])

  useEffect(() => {
    axios.get('http://localhost:8080/api/acceptedsuggests/getAll')
      .then(res => setAcceptedSuggests(res.data))
      .catch(console.error())
  })

  const orderComplete = (id, e) => {
    e.preventDefault();
    axios.delete(`http://localhost:8080/api/orders/${id}`, {
      customerName,
      productName,
      totalPrize,
      totalCount
    }).then(res => console.log('Order complete', res).catch(err => console.log(err)))
    window.location.reload(false);
  }

  const arr = orders.map((orders, index) => {
    return (
      <tr>
        <td style={{ border: '1px solid red' }}>{orders.customerName}</td>
        <td style={{ border: '1px solid red' }}>{orders.productName}</td>
        <td style={{ border: '1px solid red' }}>{orders.totalPrize} TL</td>
        <td style={{ border: '1px solid red' }}>{orders.totalCount} adet</td>
        <td style={{ border: '1px solid red' }}><button onClick={(e) => orderComplete(orders.id, e)}>complete</button></td>
      </tr>
    )
  })

  const arguman = acceptedSuggests.map((acceptedSuggests, index) => {
    return (
      <tr>
        <td style={{ border: "1px solid red" }}>{"Ad:" + acceptedSuggests.acceptedName + " Alerjen:" + acceptedSuggests.acceptedAlergen}</td>
      </tr>
    )
  })
  return (
    <div>
      <Header />
      <LeftMenu />
      <Grid container spacing={2}>
        <Grid>
        <table style={{ border: '2px solid red',marginLeft:'350px'}}>
            <h4>Kabul Edilen Öneriler</h4>
            {arguman}
          </table>
         
        </Grid>
        <Grid >
           
        <table style={{ border: '2px solid red',marginLeft:'50px'}}>
            <th style={{ border: '1px solid red' }}>Müşteri İsmi</th>
            <th style={{ border: '1px solid red' }}>Ürün Adı</th>
            <th style={{ border: '1px solid red' }}>Sipariş Tutarı</th>
            <th style={{ border: '1px solid red' }}>Ürün Miktarı</th>
            <th style={{ border: '1px solid red' }}>Sipariş Durumu</th>
            {arr}
          </table>
        </Grid>


      </Grid>

    </div>
  )
}
