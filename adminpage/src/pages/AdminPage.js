import React from 'react'
import ListAdmins from './service/ListAdmins'
import ListFoods from './service/ListFoods'
import ListOrders from './service/ListOrders'
import { Routes, Route } from 'react-router-dom';

export default function AdminPage() {
  return (
    <div>
      <Routes>
        <Route path = '/listfoods' element = {<ListFoods />}/>
        <Route path = '/listadmins' element = {<ListAdmins />}/>
        <Route path = '/' element = {<ListOrders />}/>
      </Routes>
    </div>
  )
}
