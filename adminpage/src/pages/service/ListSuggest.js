import { Grid } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Header from '../components/Header';
import LeftMenu from '../components/LeftMenu'

export default function ListSuggest() {

  const [suggests, setSuggests] = useState([]);
  const [suggestName, setSuggestName] = useState('');
  const [alergen, setAlergen] = useState('');
  const [foodType, setFoodType] = useState('');
  const [date, setDate] = useState('')
  const [message, setMessage] = useState('');

  const [acceptedSuggests, setAcceptedSuggests] = useState([]);
  const [acceptedName, setAcceptedName] = useState('Name');
  const [acceptedAlergen, setAcceptedAlergen] = useState('Alergen');
  const [areYouSure, setAreYouSure] = useState(false);
  const [variable, setVariable] = useState(1);

  useEffect(() => {
    axios.get('http://localhost:8080/api/suggests/getAll')
      .then(res => setSuggests(res.data))
      .catch(console.error())
  }, [])

  const acceptSuggest = (sugname, sugalergen, id, e) => {
    if (variable == 1) {
      setacceptedalergen(sugalergen)
      setacceptedname(sugname)
      setVariable(2)
    }
    else if (variable == 2) {
      setVariable(1)
      e.preventDefault();
      axios.post('http://localhost:8080/api/acceptedsuggests', {
        acceptedName,
        acceptedAlergen,
      }).then(res => console.log("Posting.." + sugname + sugalergen + id, res).catch(err => console.log(err)))

      axios.delete(`http://localhost:8080/api/suggests/${id}`, {
        suggestName,
        alergen,
        foodType,
        date,
        message
      }).then(res => console.log("Deleting", res).catch(err => console.log(err)))
      window.location.reload(false)
    }
  }

  const deletePost = (id, e) => {

    if (!areYouSure) {

    }
    e.preventDefault();
    axios.delete(`http://localhost:8080/api/suggests/${id}`, {
      suggestName,
      alergen,
      foodType,
      date,
      message
    }).then(res => console.log("Deleting...", res).catch(err => console.log(err)))
    window.location.reload(false);
  }

  const setacceptedname = (e) => {
    setAcceptedName(e)
  }

  const setacceptedalergen = (e) => {
    setAcceptedAlergen(e)
  }

  const arr = suggests.map((suggests, index) => {
    return (

      <tr>
        <td style={{ border: '1px solid red' }}>{suggests.suggestName}</td>
        <td style={{ border: '1px solid red' }}>{suggests.foodType}</td>
        <td style={{ border: '1px solid red' }}>{suggests.message}</td>
        <td style={{ border: '1px solid red' }}>{suggests.date}</td>
        <td style={{ border: '1px solid red' }}>{suggests.alergens}</td>
        <td style={{ border: '1px solid red' }}>
          <button style={{ marginRight: '5px', marginLeft: '5px' }} onClick={(e) => acceptSuggest(suggests.suggestName, suggests.alergens, suggests.id, e)}>Kabul et</button>
          <button style={{ marginRight: '5px' }} onClick={(e) => deletePost(suggests.id, e)}>Sil</button>
        </td>
      </tr>

    )
  })

  return (
    <div>
      <Header />
      <Grid container spacing={2}>
        <Grid sx={2}>
          <LeftMenu />
        </Grid>
        <Grid sx={10}>
          <h1 style={{ minWidth: '1230px', marginTop: '150px', backgroundColor: 'lightgray', }}>Müşterilerden Gelen Öneriler</h1>
          <h2 style={{ marginRight: '200px' }}>Öneriler</h2>
          <table style={{ border: '2px solid red', marginLeft: '50px', marginRight: '10px' }}>
            <th style={{ border: '1px solid red' }}>Yemek Adı</th>
            <th style={{ border: '1px solid red' }}>Tip</th>
            <th style={{ border: '1px solid red' }}>Mesaj</th>
            <th style={{ border: '1px solid red' }}>Tarih</th>
            <th style={{ border: '1px solid red' }}>Alerjen</th>
            <th style={{ border: '1px solid red' }}>Onay</th>
            {arr}
          </table>
        </Grid>
      </Grid>


    </div>
  )
}
