/**
 * Declarar las constantes y variables utilizadas 
 */
const url = "http://localhost:8080/api/estudiantes/"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalUsuario = new bootstrap.Modal(document.getElementById('modalUsuario'))
const formUsuario = document.querySelector('form')
var id_tipodocumento = document.getElementById("id_tipodocumento")
var numerodocumento = document.getElementById("numerodocumento")
var nombre = document.getElementById("nombre")
var apellidos = document.getElementById("apellidos")
var fecha_nacimiento = document.getElementById("fecha_nacimiento")
var id_grado = document.getElementById("id_grado")
var id_dane = document.getElementById("id_dane")
var direccion = document.getElementById("direccion")
var email = document.getElementById("email")
var celular = document.getElementById("celular")
var fijo = document.getElementById("fijo")

var opcion = ''

/**
 * Evento que activa el boton crear para abrir la ventana modal e insertar un nuevo usuario
 */
btnCrear.addEventListener('click', ()=>{
    id_tipodocumento.value = ''
    numerodocumento.value = ''
    nombre.value = ''
    apellidos.value = ''
    fecha_nacimiento.value = ''
    id_grado.value = ''
    id_dane.value = ''
    direccion.value = ''
    email.value = ''
    celular.value = ''
    fijo.value = ''
    opcion = 'crear'
})

/**
 * Ciclo para mostrar los datos de la tabla usuarios ubicada en la BD
 * @param {*} usuarios 
 */
const mostrar = (usuarios) => {
    usuarios.forEach(usuario => {
        resultados += `<tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.id_tipodocumento}</td>
                            <td>${usuario.numerodocumento}</td>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.apellidos}</td>
                            <td>${usuario.fecha_nacimiento}</td>
                            <td>${usuario.id_grado}</td>
                            <td>${usuario.id_dane}</td>
                            <td>${usuario.direccion}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.celular}</td>
                            <td>${usuario.fijo}</td>
                           
                            <td class="text-center"><a class="btnEditar btn btn-primary" data-bs-toggle="modal"  data-bs-target="#modalUsuarios">Editar</a> &nbsp&nbsp <a class="btnBorrar btn btn-danger">Borrar</a></td>
                       </tr>`
                        
    })
    contenedor.innerHTML = resultados
    
}
/**
 * Peticion por medio de fetch a la constante url utilizando la funcion mostrar para visualizar los resultados
 */
fetch(url)
    .then( response => response.json())
    .then( data => mostrar(data))
    .catch( error => console.log(error))

    const id = document.getElementById('id')

    const on = (element, event, selector, handler) => {
        element.addEventListener(event, e => {
            if (e.target.closest(selector)) {
                handler(e)
            }
        })
    }

 /**
  * Borrado Fisico
  * Procedimiento para borrar un usuario donde ubicamos por medio del id la fila a eliminar  y se realiza la peticion por fetch haciendo uso del metodo DELETE
  */
on(document, 'click', '.btnBorrar', e => {
        const fila = e.target.parentNode.parentNode
        const id = fila.firstElementChild.innerHTML
        console.log(id)
       
        
        alertify.confirm("Presione Ok para eliminar Estudiante",
        function () {
            fetch(url+id, {
                
                method:'DELETE'
            })
            .then(res => res.json())
            .then(()=> location.reload())
        },
        function () {
            alertify.error('Cancel');
        });

});
    
   

/**
 * Procedimiento ubicar el registro que se quiere editar
 */
let idForm = 0
on(document, 'click', '.btnEditar', e => {
    
    const fila = e.target.parentNode.parentNode
    idForm = fila.children[0].innerHTML
    const id_tipodocumentoForm = fila.children[1].innerHTML
    const numerodocumentoForm = fila.children[2].innerHTML
    const nombreForm = fila.children[3].innerHTML
    const apellidosForm = fila.children[4].innerHTML
    const fecha_nacimientoForm = fila.children[5].innerHTML
    const id_gradoForm = fila.children[6].innerHTML
    const id_daneForm = fila.children[7].innerHTML
    const direccionForm = fila.children[8].innerHTML
    const emailForm = fila.children[9].innerHTML
    const fijoForm = fila.children[10].innerHTML
    const celularForm = fila.children[11].innerHTML
  

    id_tipodocumento.value = id_tipodocumentoForm
    numerodocumento.value = numerodocumentoForm
    nombre.value = nombreForm
    apellidos.value =apellidosForm
    fecha_nacimiento.value = fecha_nacimientoForm
    id_grado.value = id_gradoForm
    id_dane.value = id_daneForm
    direccion.value = direccionForm
    email.value = emailForm
    fijo.value = fijoForm
    celular.value = celularForm
   
    opcion = 'editar'

})
/**
 * Crear o editar segun la variable opcion= 'crear' ó opcion= 'editar'
 * Procedimiento para actualizar un regitro por medio de  fetch  haciendo uso del metodo POST
 */
formUsuario.addEventListener('submit', (e)=>{
    e.preventDefault()
    if(opcion == 'crear'){
        
        fetch(url, {
            method:  'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                
                id_tipodocumento:id_tipodocumento.value,
                numerodocumento:numerodocumento.value,
                nombre:nombre.value,
                apellidos:apellidos.value,
                fecha_nacimiento:fecha_nacimiento.value,
                id_grado:id_grado.value,
                id_dane:id_dane.value,
                direccion:direccion.value,
                email:email.value,
                celular:celular.value,
                fijo:fijo.value,
                
            })
        })
        .then( response => response.json())
        .then( data => {
        const nuevoUsuario = []
        nuevoUsuario.push(data)
        mostrar(nuevoUsuario)
        .catch( error => console.log(error))
        })
        
    }

/**
 * Procedimiento para actualizar un regitro por medio de  fetch y el id del registro haciendo uso del metodo PUT
 */
    if(opcion == 'editar'){
        
        fetch(url+idForm, {
            method: 'PUT',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                id_tipodocumento:id_tipodocumento.value,
                numerodocumento:numerodocumento.value,
                nombre:nombre.value,
                apellidos:apellidos.value,
                fecha_nacimiento:fecha_nacimiento.value,
                id_grado:id_grado.value,
                id_dane:id_dane.value,
                direccion:direccion.value,
                email:email.value,
                celular:celular.value,
                fijo:fijo.value,
            })
           })
           .then( response => response.json())
           .then( response => location.reload())
        }
        
    })

    
    

  