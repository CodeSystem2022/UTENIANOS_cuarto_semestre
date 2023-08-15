from psycopg2 import pool
import sys
import logging

logging.basicConfig(
    level=logging.DEBUG,
    format='%(asctime)s:%(levelname)s [%(filename)s:%(lineno)s] %(message)s',
    datefmt='%I:%M:%S %p'
)
log = logging.getLogger(__name__)

class Conexion:
    _DATABASE = 'test_bd'
    _USERNAME = 'postgres'
    _PASSWORD = 'admin'
    _DB_PORT = '5432'
    _HOST = '127.0.0.1'
    _MIN_CON = 1
    _MAX_CON = 5
    _pool = None



    @classmethod
    def obtenerConexion(cls):
        pass

    @classmethod
    def obtenerCursor(cls):
        pass


    @classmethod
    def obetenerPool(cls):
        if cls._pool is None:
            try:
                cls._pool = pool.SimpleConnectionPool(
                    cls._MIN_CON,
                    cls._MAX_CON,
                    host = cls._HOST,
                    user = cls._USERNAME,
                    password = cls._PASSWORD,
                    port = cls._DB_PORT,
                    database = cls._DATABASE
                )
                log.debug(f'Creación del pool exitosa: {cls._pool}')
            except Exception as e:
                log.error(f'Error al crear el pool de conexiones: {e}')
                sys.exit()
        else:
            return cls._pool
                

if __name__ == '__main__':
    pass
