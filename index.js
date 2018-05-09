var express = require('express')
var PORT = process.env.PORT || 5000 

app = express()

var route = express.Router();

route.get('/',function(req,res){
    res.json({'mensaje':'Hola Api'})
})

app.use('/api',route)
app.listen(PORT, () => 
            console.log('Escucahndo en el puerto ', PORT))