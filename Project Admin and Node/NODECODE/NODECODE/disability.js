const express =  require('express');
const config = require('config');
const appForDisability = express.Router();
const mysql = require('mysql');
var connection = mysql.createConnection({
    host     : config.get("host"),
    user     :  config.get("user"),
    password :  config.get("password"),
    database :  "medical"
    
});

appForDisability.get("/:uid", (request, response)=>{
    connection.query(`select dis_status from medical_records where Uid = ${request.params.uid}`, (error, result)=>{
        
                if(error==null)
                {
                    
                    
                    
                    response.setHeader("Content-Type","application/text");
                   
                     if(result[0].dis_status==1){
                     response.write("true");
                     }
                     else{
                         response.write("false");
                     }
                } 
                else
                {
                    console.log(error);
                    response.setHeader("Content-Type","application/json");
                    response.write("Something went wrong");
                }
                response.end();
    })

})


// appForEmps.post("/", (request, response)=>{
   
//     var query = 
//     `insert into Employee_Tb values(${request.body.id},'${request.body.e_name}','${request.body.email}','${request.body.password}',${request.body.emp_id},'${request.body.dname}',${request.body.doj})`;

//     connection.query(query, (error, result)=>{
//         if(error==null)
//         {
//             var data = JSON.stringify(result) 
//             response.setHeader("Content-Type","application/json");
//             response.write(data);
//         } 
//         else
//         {
//             console.log(error);
//             response.setHeader("Content-Type","application/json");
//             response.write(error)
//         }
//         response.end();
// })
// })


// appForEmps.put("/:id", (request, response)=>{
    
//     var query = 
//     `update Employee_Tb set e_name = '${request.body.e_name}',
//                     email= '${request.body.email}' where Eno = ${request.params.id}`;

//     connection.query(query, (error, result)=>{
//                         if(error==null)
//                 {
//                             var data = JSON.stringify(result) 
//                             response.setHeader("Content-Type","application/json");
//                             response.write(data);
//                         } 
//                         else
//                         {
//                             console.log(error);
//                             response.setHeader("Content-Type","application/json");
//                             response.write(error)
//                         }
//                         response.end();
//                 })
// })

// appForEmps.delete("/:Eno", (request, response)=>{
    
//     var query = 
//     `delete from Employee_Tb where id = ${request.params.id}`;
                    
//     connection.query(query, (error, result)=>{
//                         if(error==null)
//                         {
//                             var data = JSON.stringify(result) 
//                             response.setHeader("Content-Type","application/json");
//                             response.write(data);
//                         } 
//                         else
//                         {
//                             console.log(error);
//                             response.setHeader("Content-Type","application/json");
//                             response.write(error)
//                         }
//                         response.end();
//                 })
// })

module.exports = appForDisability;