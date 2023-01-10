import React, {useState, useEffect} from 'react'
import Header from '../components/Header';
import LeftMenu from '../components/LeftMenu';
import axios from 'axios'

export default function ListFoods() {
    const [foods, setFoods] = useState([]);
    const [name, setName] = useState('');
    const [count, setCount] = useState();
    const [prize, setPrize] = useState();
    const [alergens, setAlergens] = useState('');
    const [companyName, setCompanyName] = useState('');
    const [foodType , setFoodType] = useState('');
    const [image, setImage] = useState('');
    
    useEffect(() => {
        axios.get('http://localhost:8080/api/foods/getAll')
        .then(res => setFoods(res.data))
        .catch(console.error())
    },[])

    const postFood = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/foods',{
            name,
            count,
            prize,
            alergens,
            companyName,
            foodType,
            image
        }).then(res => console.log('Posting food',res)).catch(err => console.log(err))
        window.location.reload(false);
    }

    const postDelete = (id,e) => {
        e.preventDefault();
        axios.delete(`http://localhost:8080/api/foods/${id}`,{
            name,
            count,
            prize,
            alergens,
            companyName,
            foodType,
            image
        }).then(res => console.log('Deleting', res)).catch(err => console.log(err))
        window.location.reload(false);
    }

const arr = foods.map((foods,index) => {
    return (
        <tr>
            <td style = {{border : '1 px solid red'}}>{foods.id}</td>
            <td style = {{border : '1 px solid red'}}>{foods.name}</td>
            <td style = {{border : '1 px solid red'}}>{foods.count} adet</td>
            <td style = {{border : '1 px solid red'}}>{foods.prize} TL</td>
            <td style = {{border : '1 px solid red'}}>{foods.alergens}</td>        
            <td style = {{border : '1 px solid red'}}>{foods.companyName}</td>
            <td style = {{border : '1 px solid red'}}>{foods.foodType}</td>
            <td style = {{border : '1 px solid red'}}><img src = {foods.image} width = '100px'/></td>
            <td style = {{border : '1 px solid red'}}><button onClick={(e) => postDelete(foods.id,e)}>delete</button></td>
        </tr>
    )
})
  return (
    <div>
      <Header />
        <LeftMenu />
      <table style = {{border: '2px solid red', marginLeft : '100px', marginTop : '10px'}}>
        <th style = {{border: '1px solid red'}}>ID</th>
        <th style = {{border: '1px solid red'}}>Yemek Adı</th>
        <th style = {{border: '1px solid red'}}>Stok Adedi</th>
        <th style = {{border: '1px solid red'}}>Fiyatı</th>
        <th style = {{border: '1px solid red'}}>İçerdiği Alerjen</th>
        <th style = {{border: '1px solid red'}}>Üretici Firma</th>
        <th style = {{border: '1px solid red'}}>Yemek Tipi</th>
        <th style = {{border: '1px solid red'}}>Resim</th>
        <tr>
            <td style = {{border: '1px solid red'}}>Food Id</td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {name} onChange = {(e) => setName(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {count} onChange = {(e) => setCount(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {prize} onChange = {(e) => setPrize(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {companyName} onChange = {(e) => setCompanyName(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {alergens} onChange = {(e) => setAlergens(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {foodType} onChange = {(e) => setFoodType(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><input type = 'text' value = {image} onChange = {(e) => setImage(e.target.value)}></input></td>
            <td style = {{border: '1px solid red'}}><button onClick = {postFood}>Send</button></td>
        </tr>
        {arr}
      </table>
    </div>
  )
}

