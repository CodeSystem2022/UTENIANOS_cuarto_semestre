import  {Router} from "express";
import {signin, signup, signout, profile } from ".../controllers/controller.js"

const router = Router();

router.post('/signin',signin);

router.post('/signup',signup);
 
router.post('/signoup',signout);
 
router.get('/profile',profile);   
 

export default router;
