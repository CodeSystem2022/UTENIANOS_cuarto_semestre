import sqlite3 as sql3

con = sql3.connect('mi_db.db')
cur = con.cursor()

cur.execute('''CREATE TABLE IF NOT EXISTS alumnos(legajo VARCHAR(7) PRIMARY KEY, nombre VARCHAR(30), apellido VARCHAR(30), nota DECIMAL(10,0))''')
#cur.execute('INSERT INTO alumnos VALUES ("26847", "Agustin", "Saba", 7.5)')

for registro in cur.execute('SELECT * FROM alumnos'):
    print(registro)

con.commit()
con.close()