import React, { useState } from 'react'
import SuggestNavbar from '../components/SuggestNavbar'
import Box from '@mui/material/Box'
import { Button, Grid } from '@mui/material'
import axios from 'axios'
import InputLabel from '@mui/material/InputLabel'
import MenuItem from '@mui/material/MenuItem'
import FormControl from '@mui/material/FormControl'
import Select from '@mui/material/Select'

export default function SuggestEvaluation() {
  const [suggests, setSuggests] = useState([]);
  const [suggestName, setSuggestName] = useState('');
  const [message, setMessage] = useState('');
  const [alergens, setAlergens] = useState('');
  const [foodType, setFoodType] = useState('');
  const [date, setDate] = useState('');

  const postSuggest = (e) => {
    if(alergens == "")
    {
      alert('Lütfen bir alerjen türü belirtiniz.');
    }
    else if(foodType == "")
    {
      alert('Lütfen bir yiyecek türü belirtiniz.')
    }

    else{
    e.preventDefault();
    axios.post('http://localhost:8080/api/suggests', {
      suggestName,
      message,
      alergens,
      foodType,
      date,
    }).then(res => console.log("Posting...", res)).catch(err => console.log(err))
    window.location.reload(false);
    alert('Öneriniz başarıyla gönderildi.')
  }
  }

  const handleChangeAlergen = (e) => {
    setAlergens(e.target.value);
    setDate(new Date().toLocaleDateString('tr-TR'))
  }

  const handleChangeFoodType = (e) => {
    setFoodType(e.target.value);
  }

  return (
    <div>
      <SuggestNavbar />


      <Box style={{ border: '3px solid black', width: '1000px', height: '550px', marginLeft: '250px', marginTop: '100px' }}>
        <h3>Öneri Mesajı</h3>
        <p>Buraya ekibimize iletmek istediğiniz mesajı giriniz. Lütfen aşağıya ürün adı ve tipini girmeyi unutmayınız.</p>
        <Grid container spacing={0}>
          <Grid>
            <form style={{ marginLeft: '100px' }}>
              <h4><label for="suggestmsg">Mesajınız</label></h4>
              <textarea id="suggestmsg" name="suggestmsg" rows="10" cols="50" value={message} onChange={(e) => setMessage(e.target.value)}></textarea>
            </form>
            <form style={{ marginRight: '110px' }}>
              <h4><label for="suggestname">Ürün Adı</label></h4>
              <textarea id="suggestname" name="suggestname" value={suggestName} onChange={(e) => setSuggestName(e.target.value)}></textarea>
            </form>
          </Grid>
          <Grid>
            <form style={{ marginLeft: '150px' }}>
              <h4><label for="allergens">Alerjen</label></h4>
              <Box sx={{ minWidth: 120 }}>
                <FormControl style={{ width: '150px' }}>
                  <InputLabel id="allergens">Alerjeni seçiniz</InputLabel>
                  <Select
                    labelId="allergens"
                    id="allergens"
                    value={alergens}
                    label="Alergens"
                    onChange={handleChangeAlergen}>
                    <MenuItem value={"Gluten"}>Gluten</MenuItem>
                    <MenuItem value={"Süt Ürünleri"}>Süt Ürünleri</MenuItem>
                    <MenuItem value={"Et Ürünleri"}>Et Ürünleri</MenuItem>
                    <MenuItem value={"Deniz Ürünleri"}>Deniz Ürünleri</MenuItem>
                  </Select>
                </FormControl>
              </Box>
            </form>
            <form style={{ marginLeft: '150px' }}>
              <h4><label for="suggesttype">Yemek Türü</label></h4>
              <Box sx={{ minWidth: 120 }}>
                <FormControl style={{ width: '150px' }}>
                  <InputLabel id="suggesttype">Yemek Türünü Seçiniz</InputLabel>
                  <Select
                    labelId="suggesttype"
                    id="suggesttype"
                    value={alergens}
                    label="Food Type"
                    onChange={handleChangeFoodType}>
                    <MenuItem value={"Çorba"}>Çorba</MenuItem>
                    <MenuItem value={"Ana Yemek"}>Ana Yemek</MenuItem>
                    <MenuItem value={"Fast Food"}>Fast Food</MenuItem>
                    <MenuItem value={"Ev Yemeği"}>Ev Yemeği</MenuItem>
                    <MenuItem value={"Tatlı"}>Tatlı</MenuItem>
                  </Select>
                </FormControl>
              </Box>
            </form>
          </Grid>
          <Grid>

          </Grid>

        </Grid>
        <Button style={{ border: "1px solid red" }} onClick={postSuggest}>Önerimi Gönder</Button>
      </Box>

    </div>
  )
}
