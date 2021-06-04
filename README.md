
<p align='center'>
  <img src=https://assets.entrepreneur.com/content/3x2/2000/20160520193328-xmen.jpeg?width=700&crop=2:1 width="500">
</p>

# Prueba Técnica Meli

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.



## Instalación

- Clonar el repositorio. git clone https://github.com/ElianaGomez2020/meli/


## Uso

La api /mutant/ detecta si un ADN de un humano es mutante o no mediante un HTTP POST con un Json el cual tenga el siguiente formato:



POST → localhost:8081/mutant/


{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

En caso de verificar un mutante, devuelve un HTTP 200-OK, en caso contrario un 403-Forbidden.

Observaciones:

Para hostear la API utilicé Google Cloud : https://storage.cloud.google.com/staging.magneto-315718.appspot.com/us.gcr.io/magneto-315718/appengine/default.magneto1%3Alatest?authuser=1
 
Para probar la funcionalidad de la misma utilicé postman POST : https://magneto-315718.uc.r.appspot.com/mutant
