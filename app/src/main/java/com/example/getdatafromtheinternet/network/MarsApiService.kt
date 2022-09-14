package com.example.getdatafromtheinternet.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

/*Esta es la URL base que apunta al servidor y de la cual van a partir el resto de recursos a los que
podemos acceder.*/
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

/*
1-  Nos creamos nuestro primer objeto retrofit.
2-  Le añadimos un conversor el cual le indica al objeto qué hacer con los datos que obtiene del
    servicio web. En este caso en concreto queremos obtener un JSON y convertirlo a String. Retrofit
    tiene un ScalarsConverter que admite strings y otros tipos primitivos
3-  Agregamos el URI de base para el servicio web con el método.
4-  Creamos el objeto (lo construimos)
*/
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


