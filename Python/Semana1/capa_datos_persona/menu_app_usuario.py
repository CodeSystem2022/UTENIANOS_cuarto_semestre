from Usuario import Usuario
from usuario_dao import UsuarioDAO
from logger_base import log

opcion = None
while opcion != 5:
    print('Opciones: ')
    print('1. Listar usuarios')
    print('2. Agregar usuario')
    print('3. Editar usuario')  
    print('4. Eliminar usuario')
    print('5. Salir')
    opcion = int(input('Ingrese una opción: '))
    if opcion == 1:
        usuarios = UsuarioDAO.seleccionar()
        for usuario in usuarios:
            log.info(usuario)

else:
    log.info('Salimos del programa')
    