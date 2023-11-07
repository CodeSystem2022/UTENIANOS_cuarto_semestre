import tkinter as tk

#Creamos la ventana
window = tk.Tk()

#Creamos una etiqueta
label = tk.Label(window, text="hola mundo!")

#Creamos un botón
button = tk.Button(window, text="Salida", command=window.destroy)

#Agregamos la etiqueta y boton a la ventana
label.pack()
button.pack()

