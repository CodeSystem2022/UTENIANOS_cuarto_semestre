import pg from "pg";

import const pool = new pg.Pool({
    port: 5432
    host: "localhost",
    user: "postgres",
    pasword:"admin",
    database: "PERN",
}); 
pool.on{"connect", () => {
    console.log ("conectado a la base de datos");
    
});
