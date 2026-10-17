# Hospital Veterinario

Proyecto de consola en Java para la evaluación de POO. Sirve para manejar los pacientes de una clínica veterinaria.

## Qué hace

- Ingresar perros, gatos y aves
- Vacunar perros
- Asignar una jaula a un paciente
- Medicar pacientes
- Dar de alta
- Ver un reporte con todos los pacientes y las jaulas libres

## Cómo lo hice

Hice 6 clases:

- **Paciente:** es la clase padre. Tiene nombre, peso, edad, estado, factor de dosis, dosis acumulada y la jaula.
- **Perro, Gato y AveExotica:** heredan de Paciente y cada una tiene sus propios datos (raza y vacunado, nivel de estrés, envergadura).
- **Jaula:** tiene número, tamaño, zona y el paciente que la ocupa.
- **Hospital:** guarda los pacientes en un vector de 10 y las jaulas en un vector de 6. Aquí está toda la lógica y las reglas.
- **Main:** es la única que usa Scanner y System.out. Muestra un menú y llama a Hospital.

Los atributos son privados y los setters validan los datos. Usé solo vectores, no ArrayList.

Después se elige un número del menú y el programa va pidiendo los datos.

## Nota

El enunciado pedía escribir comandos en una línea, pero yo hice un menú con números para que fuera más fácil de usar. Las reglas y los mensajes son los del enunciado.

cabe recalcar que me ayude la IA Claude
