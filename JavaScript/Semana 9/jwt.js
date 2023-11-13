importar  jwt  desde  "jsonwebtoken" ;

exportar  const  createAccessToken  =  ( carga útil )  =>  {
    devolver  nueva  Promesa ( ( resolver ,  rechazar )  =>  {
        jwt . firmar ( carga útil ,  "xyz123" ,  { expide en : "1d"  } ,
        ( errar ,  token )  =>  {
            si ( err )  rechazar  ( err ) ;
            resolver ( símbolo ) ;
    } ) ;
    } ) ;
} ;