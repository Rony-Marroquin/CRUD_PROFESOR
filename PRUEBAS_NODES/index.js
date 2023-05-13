const express = require('express')
const mysql = require('mysql')
const bodyParser = require('body-parser')

const app = express()

app.use(function(req, res, next) {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', '*');
    res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next()
})

app.use(bodyParser.json())

const PUERTO = 3000

const conexion = mysql.createConnection(
    {
        host:'localhost',
        // cambia el nombre de la base de datos "alumno" para futuros proyectos
        database: 'alumno',
        user: 'root',
        password: ''
    }
)

app.listen(PUERTO, () => {
    console.log(`Servidor corriendo en el puerto ${PUERTO}`);
})

conexion.connect(error => {
    if(error) throw error
    console.log('Conexión exitosa a la base de datos');
})

app.get('/', (req, res) => {
    res.send('API')
})
// aqui cambiar por el nombre de la tabla o ruta de "estdudiantes "para futuros proyectos
app.get('/estudiantes', (req, res) => {
           //   select * from "nombre de la ruta"
    const query = 'SELECT * FROM estudiantes;'
    conexion.query(query, (error, resultado) => {
        if(error) return console.error(error.message)

        const obj = {}
        if(resultado.length > 0) {
            //ruta listado
            obj.listaestudiantes = resultado
            res.json(obj)
        } else {
            res.send('No hay registros')
        }
    })
})

app.get('/estudiante/:id', (req, res) => {
    const { id } = req.params

    const query = `SELECT * FROM estdudiante WHERE idEstudiante=${id};`
    conexion.query(query, (error, resultado) => {
        if(error) return console.error(error.message)

        if(resultado.length > 0){
            res.json(resultado);
        } else {
            res.send('No hay registros');
        }
    })
})
   //modificar ruta para futuros proyectos y parametro solicitados
app.post('/estudiante/add', (req, res) => {
    const estudiante = {
        Nombre: req.body.Nombre,
        Apellido: req.body.Apellido,  
        Edad: req.body.Edad
    }

    const query = `INSERT INTO estudiante SET ?`
    conexion.query(query, estudiante, (error) => {
        if(error) return console.error(error.message)

        res.json(`Se inserto correctamente el estudiante`)
    })
})

app.put('/estudiante/update/:id', (req, res) => {
    const { id } = req.params
    const { Nombre, Apellido,Edad  } = req.body

    const query = `UPDATE estudiantes SET Nombre='${Nombre}', Apellido='${Apellido}',Edad='${Edad}' WHERE idEstudiante='${id}';`
    conexion.query(query, (error) => {
        if(error) return console.log(error.message)

        res.json(`Se actualizó correctamente el estudiante`)
    })
})

app.delete('/estudiante/delete/:id', (req, res) => {
    const { id } = req.params

    const query = `DELETE FROM estudiantes WHERE idEstudiante=${id};`
    conexion.query(query, (error) => {
        if(error) return console.log(error.message)

        res.json(`Se eliminó correctamente el estudiante`)
    })
})



