import * as React from 'react';
import Divider from '@mui/material/Divider';
import Paper from '@mui/material/Paper';
import MenuList from '@mui/material/MenuList';
import MenuItem from '@mui/material/MenuItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemIcon from '@mui/material/ListItemIcon';
import Home from '@mui/icons-material/Home';
import Adminler from '@mui/icons-material/Person';
import Products from '@mui/icons-material/LunchDining';
import MessageIcon from '@mui/icons-material/Email';
import { Link } from 'react-router-dom';

export default function IconMenu() {
  return (
    <Paper sx={{ marginTop: '80px', width: 320, maxWidth: '100%' }}>
      <MenuList>

        <Link to="/">
          <MenuItem>
            <ListItemIcon>
              <Home fontSize='small' />
            </ListItemIcon>
            <ListItemText>Dashboard</ListItemText>
          </MenuItem>
        </Link>

        <Divider />

        <Link to='/listfoods'>
          <MenuItem>
            <Products fontSize='small' />
            <ListItemText>Ürün ekle</ListItemText>
          </MenuItem>
        </Link>

        <Divider />

        <Link to = '/listadmins'>
          <MenuItem>
            <ListItemIcon>
              <Adminler fontSize="small" />
            </ListItemIcon>
            <ListItemText>Adminler</ListItemText>
          </MenuItem>
        </Link>

        <Divider />

      <Link to = '/listsuggests'>
        <MenuItem>
        <ListItemIcon>
          <MessageIcon fontSize = "small" />
        </ListItemIcon>
        <ListItemText>Öneriler</ListItemText>
        </MenuItem>
      </Link>

      </MenuList>
    </Paper>
  );
}