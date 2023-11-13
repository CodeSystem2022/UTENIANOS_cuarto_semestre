import {pool} from "../db.js"
import bcrypt from "bcrypt";
import {createAccessToken} from "../libs/jwt.js"
import md5 from "md5";

export const signin = (req, res)=> res.send('ingresando');

export const signup = (req, res)=> res.send('registrando');

export const signout = (req, res)=> res.send('Cerrando');

export const profile = (req, res)=> res.send('Perfil');
