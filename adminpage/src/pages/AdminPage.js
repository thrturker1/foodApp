import React from 'react'
import ListAdmins from './service/ListAdmins'
import ListFoods from './service/ListFoods'
import ListOrders from './service/ListOrders'
import { Routes, Route } from 'react-router-dom';
import ListSuggest from './service/ListSuggest';
import SuggestEvaluation from './service/SuggestEvaluation';

export default function AdminPage() {
  return (
    <div>
      <Routes>
        <Route path = '/listfoods' element = {<ListFoods />}/>
        <Route path = '/listadmins' element = {<ListAdmins />}/>
        <Route path = '/' element = {<ListOrders />}/>
        <Route path = '/listsuggests' element = {<ListSuggest/>}/>
        <Route path = '/suggestarea' element = {<SuggestEvaluation/>}/>
      </Routes>
    </div>
  )
}
