# API-Restaurante

Para este ejercicio, se pide implementar una API REST sobre bares o restaurantes de moda en Sevilla y alrededores. De cada bar o restaurante queremos saber los siguientes datos:
Su ID (un número entero largo)
Su nombre
Su dirección (calle, ciudad)
Su localización (latitud, longitud).
Un descripción del mismo
Una serie de tags asociados al bar o restaurante
La URL de una foto.
Todos estos datos hay que modelarlos con una única clase.

La estructura de rutas, peticiones y códigos de respuesta deberían ser los siguientes:

PETICIÓN
RUTA
VERBO HTTP
CÓDIGO RESPUESTA
Listar todos los bares o restaurantes
/place/
GET
200 Si existe alguno
404 Si no hay
Listar un bar o restaurante por su id
/place/id
GET
200 Si se encuentra
404 Si no se encuentra
Crear un nuevo bar o restaurante
/place/
POST
201 Si se ha creado
Modificar un bar o restaurante*
/place/id
PUT
200 Si se encuentra y modifica
404 Si no se encuentra
Agregar un tag a un restaurante**
/place/id/tag/
add/{nuevo_tag}
PUT
200 Si se encuentra y modifica
404 Si no se encuentra
Eliminar un tag de un restaurante**
/place/id/tag/
del/{tag}
PUT
200 Si se encuentra y modifica
404 Si no se encuentra
Eliminar un bar o restaurante
/place/id
DELETE
204 En cualquier caso.


* Para la petición de modificar un restaurante, se podrán modificar todos los datos, menos el ID, que no puede cambiar nunca, y los tags, que se modifican con otras peticiones.
** Estas peticiones llevan dos parámetros en el path: el ID del bar o restaurante a modificar, y el tag a añadir o eliminar; y no llevan nada en el cuerpo de la petición ¡OJO! Solamente se puede eliminar un tag a la vez. Si un bar tiene por ejemplo tres tags, y se elimina uno de ellos, deben quedar los otros dos.

SE AGRADECE QUE EL API TENGA DE PARTIDA ALGUNOS DATOS DE EJEMPLO (dos o tres bares o restaurantes)

METODOLOGÍA PARA REALIZARLO

Crea un repositorio privado y añádeme como colaborador (josgarmar31)
Realiza todo el proyecto en el repositorio y súbelo antes de la hora de entrega.
Se agradece que adjuntes una colección de POSTMAN en el repositorio.
Adjunta en classroom la URL del repositorio.
