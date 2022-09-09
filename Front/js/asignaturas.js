/**
 * Declarar las constantes y variables utilizadas 
 */
 const url = "http://localhost:8080/api/asignaturas/"
 const contenedor = document.querySelector('tbody')
 let resultados = ''
 
 const modalUsuario = new bootstrap.Modal(document.getElementById('modalUsuario'))
 const formUsuario = document.querySelector('form')
 var nombre = document.getElementById("descripcion")
 var nombre = document.getElementById("id_docente")

 var opcion = ''
 
 /**
  * Evento que activa el boton crear para abrir la ventana modal e insertar un nuevo usuario
  */
 btnCrear.addEventListener('click', ()=>{
    
    nombre.value = ''
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
                             <td>${usuario.descripcion}</td>
                             <td>${usuario.id_docente}</td>
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
        
         alertify.confirm("Presione Ok para eliminar Asignatura",
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
     const nombreForm = fila.children[1].innerHTML
     nombre.value = nombreForm
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
                 
                nombre:nombre.value,
    
             })
         })
         .then( response => response.json())
         .then( data => {
         const nuevoUsuario = []
         nuevoUsuario.push(data)
         //.then( response => location.reload())
         mostrar(nuevoUsuario)
         
         })
         //.then( response => location.reload())
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
                nombre:nombre.value,
              
             })
            })
            .then( response => response.json())
            .then( response => location.reload())
         }
         
     })