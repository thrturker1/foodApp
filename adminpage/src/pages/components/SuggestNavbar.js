import React from 'react';
import { AppBar , Toolbar} from '@mui/material';
import { styled, alpha } from '@mui/material/styles';
import Person4 from "@mui/icons-material/Person4";
import PersonNormal from '@mui/icons-material/Person';
import SearchIcon from '@mui/icons-material/Search';
import ShopingCart from '@mui/icons-material/ShoppingCartCheckout';
import InputBase from '@mui/material/InputBase';

const Search = styled('div')(({ theme }) => ({
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: alpha(theme.palette.common.black, 0.15),
    '&:hover': {
      backgroundColor: alpha(theme.palette.common.black, 0.25),
    },
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      marginLeft: theme.spacing(70),
      width: 'auto',
    },
  }));

  const SearchIconWrapper = styled('div')(({ theme }) => ({
    
    padding: theme.spacing(0, 2),
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  }));
  
  const StyledInputBase = styled(InputBase)(({ theme }) => ({
    color: 'inherit',
    '& .MuiInputBase-input': {
      padding: theme.spacing(1, 1, 1, 0),
      paddingLeft: `calc(1em + ${theme.spacing(4)})`,
      transition: theme.transitions.create('width'),
      width: '100%',
      [theme.breakpoints.up('sm')]: {
        width: '12ch',
        '&:focus': {
          width: '20ch',
        },
      },
    },
  }));

const Header = () => {

    return(
        <React.Fragment>
            <AppBar sx = {{background : '000000' }}>
                <Toolbar>
                        <Person4 sx = {{marginRight : "10px",color:'#CC0000'}}/>
                        <a href='http://localhost:4200' rel='noreferrer'>
                        <p style={{color: 'red'}}>Güvenle Ye</p>
                        </a>
                        

                        <Search className = 'Search'>
                            <SearchIconWrapper style={{color:'black'}}>
                                <SearchIcon style = {{color:'black'}}/>
                            </SearchIconWrapper>
                            <StyledInputBase
                                placeholder="Search…"
                                inputProps={{ 'aria-label': 'search' }}
                                />
                        </Search>
                        <PersonNormal sx = {{marginLeft : "540px",color:'#CC0000'}}/>
                        <ShopingCart sx = {{marginLeft: "17px", color:'#CC0000'}}/>
                        
                    
                </Toolbar>
            
            </AppBar>
        </React.Fragment>
    );
}

export default Header;