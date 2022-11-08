# Tecnologías-de-Programación


## Práctica 1 --> Nota: 8.5

<ins>Fallos:</ins>

- La función "toString" no cumple los requisitos especificados en el enunciado
  
  Para el polinomio inicializado con "new int[] {-1, 1, -2, -1}" retorna la cadena "--1x^3-2x^2+x-1". Incluye dos símbolos "-" al inicio.
  

## Práctica 2 --> Nota: 8

<ins>Fallos:</ins>

- El método elementos() no comple con la especificación


## Práctica 3 --> Nota: 10


## Práctica 4.1 --> Nota: 8.25

<ins>Fallos:</ins>

- El método EnrolledStudents.addStudent() devuelve que añade un estudiante que ya está. Las clases Student y Course no implementan los métodos equals y hashCode.

- Si el código del comparador solo se usa en una ocasión, el comparador es mejor definirlo como clase anónima o lambda.

- El código no contiene pruebas suficientes para comprobar la especificación de todos los métodos 


## Práctica 4.2 --> Nota: 8

<ins>Fallos:</ins>

- La estética de los cuadros de diálogo no se ajusta a lo solicitado. 
  
  Los diálogos no tienen la estética propuesta.

- Actualización de lista de usuarios según orden seleccionado. 
  
  Las actualizaciones de las listas no se producen justo después de una modificación

- El estilo de programación tiene defectos por ausencia de comentarios de documentación (xd 🤣)


## Práctica 4.2 --> Nota: 9.5

<ins>Fallos:</ins>

- En el método addName de FileNames se usa notifyAll en lugar de notify.
  
  Es innecesario avisar a más de un FileReader para procesar el nombre que se añade (-0.5 por usar notifyAll() en vez de notify() 🙄🤡)
