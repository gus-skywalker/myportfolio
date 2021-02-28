const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const MongoClient = require('mongodb').MongoClient
const uri = "<!-- insira aqui o caminho para seu BD -->"
MongoClient.connect(uri, (err, client) => {
  // ... start the server
})

app.use(bodyParser.urlencoded({extended: true}))

app.listen(3000, function() {
    console.log('server running on port 3000')
})

app.set('view engine', 'ejs')

app.get('/', (req, res) => {
    res.render('/Users/gustavodamasceno/code/views/index.ejs')
})

app.post('/show', (req, res) => {
    console.log(req.body)
})
