import {Router} from "express";
import { ListarTareas } from ".../controllers/controlle.js"

const router =  Router();

router.get('/tareas',ListarTareas); 

router.get('/tareas/:id', listarTarea ); 

router.post('/tareas',crearTarea  ); 

router.put('/tareas/id',actualizarTarea); 

router.delete('/tareas/id', eliminarTarea ); 

export default router;
