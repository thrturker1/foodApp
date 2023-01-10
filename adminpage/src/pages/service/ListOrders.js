import React, {useState, useEffect} from 'react'
import Header from '../components/Header'
import LeftMenu from '../components/LeftMenu'
import axios from 'axios'
export default function ListOrders() {
    const [orders, setOrders] = useState([]);
    const [customerName, setCustomerName] = useState('');
    const [productName, setProductName] = useState('');
    const [totalPrize, setTotalPrize] = useState();
    const [totalCount, setTotalCount] = useState();

    const [suggests, setSuggests] = useState([]);
    
    useEffect(() => {
        axios.get('http://localhost:8080/api/orders/getAll')
        .then(res => setOrders(res.data))
        .catch(console.error())
    }, [])

    const orderComplete = (id,e) => {
        e.preventDefault();
        axios.delete(`http://localhost:8080/api/orders/${id}`,{
            customerName,
            productName,
            totalPrize,
            totalCount
        }).then(res =>console.log('Order complete', res).catch(err=> console.log(err)))
        window.location.reload(false);
    }

    const arr = orders.map((orders,index) => {
        return(
        <tr>
            <td style = {{border: '1px solid red'}}>{orders.customerName}</td>
            <td style = {{border: '1px solid red'}}>{orders.productName}</td>
            <td style = {{border: '1px solid red'}}>{orders.totalPrize} TL</td>
            <td style = {{border: '1px solid red'}}>{orders.totalCount} adet</td>
            <td style = {{border: '1px solid red'}}><button onClick={(e) => orderComplete(orders.id,e)}>complete</button></td>
        </tr>
        )
    })

  return (
    <div>
      <Header/>
      <LeftMenu/>
      <table style = {{border: '2px solid red', marginLeft : '500px'}}>
        <th style = {{border: '1px solid red'}}>Müşteri İsmi</th>
        <th style = {{border: '1px solid red'}}>Ürün Adı</th>
        <th style = {{border: '1px solid red'}}>Sipariş Tutarı</th>
        <th style = {{border: '1px solid red'}}>Ürün Miktarı</th>
        <th style = {{border: '1px solid red'}}>Sipariş Durumu</th>
        {arr}
      </table>
    
    </div>
  )
}
