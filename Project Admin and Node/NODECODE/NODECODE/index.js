const express =  require('express');
const config = require('config');
const disRelatedRoutes = require('./disability');
const app = express();


app.use((request, response, next)=>{
    response.setHeader('Access-Control-Allow-Origin',"*");
    response.setHeader('Access-Control-Allow-Headers',"*");
    response.setHeader('Access-Control-Allow-Methods', "*")
    next();
})

app.use(express.json()); 

app.use('/pwdstatus',disRelatedRoutes)


const portNo = config.get("PORT");
app.listen(portNo,()=>{console.log("Server Started at " + portNo)})