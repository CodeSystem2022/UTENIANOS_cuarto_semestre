import psycopg2

conexion = psycopg2.connect(
    user = 'postgres',
    pasword = 'admin',
    host = '127.0.0.1',
    port = '5432',
    database = 'test_bd'
)

try:
    with conexion:
        with conexion.cursor() as cursor:
            sentencia = 'SELECT * FROM persona WHERE id_persona = %s' #Placeholder
            id_persona = input('Digite un número para el id_persona')
            cursor.execute(sentencia, (id_persona,)) #De esta manera ejecutamos la sentencia
            registros = cursor.fetchone() #Recuperamos todos los registros que serán una lista
            print(registros)
except Exception as e:
    print(f'Ocurrió el siguiente error: {e}')
finally:
    conexion.close()