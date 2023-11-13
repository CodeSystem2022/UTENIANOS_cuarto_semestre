import {pool} from  "../db.js";

export const listarTareas = async(req, res) => {
    const resultado = await pool.query('SELECT * FROM tareas'); 
    console.log(resultado);
    return res.json(resultado.rows);
}    

export const listarTareas = async(req, res) => {
   const resultado = await pool.query('SELECT * FROM tareas WHERE id = $1',[req.params.id]); 
   if (resultado.rowCount === 0) {
   return res.status(404).json{
    message: 'la tarea no existe'
 });
}   

export const crearTarea = async (req, res, next ) => {
  const {título, descripcion } = req.body;

   try {
       const result= await pool.query('INSERT INTO Tareas (titulo,descripcion) VALUE ($1, $2)', [titulo,descripcion ]);
       res.json(result.rows[0]);
       console.log(result.rows[0]);
       } catch (error) {
       if(error.code ==='23505') {
            return res.send ('ya existe una tarea con ese titulo');
               message:'Ya existe una tarea con ese titulo'
             });

       }

        console.log("error");
        next(error); 

    }
};

export const actualizarTarea = async (req, res) => {
    const (titulo, descripcion) =  req.body;
    const id = req.params.id;
    const result = await pool.query('UPDATE tareas SET titulo =$1, descripcion = $2 WHERE id = $3 RETURNIN*',[titulo,descripcion, id]);
    
    if (result.rowCount === 0) {
        return res.status(404).json{
         message: 'No existe una tarea con ese id'
      });
    return res.json(result.row);
} 
    export const eliminarTarea = (req, res) => {
       const resultado = await pool.query('DELETE FROM tareas WHERE id = #$1',[req.params.id]);
        if (result.rowCount === 0) {
            return res.status(404).json{
             message: 'No existe una tarea con ese id'
      });
    }  
        return res.sendStatus(204);
}
