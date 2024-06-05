"use client"
import React, {useState, useEffect} from 'react'
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  }));

export default function page() {
    
    const init = [
        {
            "id": 0,
            "product_code": "",
            "product_name": "",
            "product_price": 0,
            "product_amount": 0
        }
    ];

    const [ product, setProduct] = useState(init);
    const [count, setCount] = useState(0);
    
    useEffect(()=>{
        fetch("http://localhost:8080/product")
            .then( res => res.json() )
            .then( result => setProduct(result) )
    },[]);

  return (
    <div>
        <h1>Product List</h1>
        Shopping Cart = {count}
        <Grid container spacing={2}>
            {
                product.map((data, i) => (
                <Grid item xs={2} key={i}>
                    <Item> 
                        code:{data.product_code} <br/> 
                        name: {data.product_name} <br/>
                        price : {data.product_price} <br/>
                        <Button variant="contained" onClick={() => setCount(count + 1)}>
                            AddTo Cart
                        </Button>
                    </Item>
                </Grid>
            
                ))
            }

        </Grid>
        

    </div>
  )
}
