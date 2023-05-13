package com.example.proyectocatedrafiinal.profesor

import com.example.proyectocatedrafiinal.Alumno.Alumno
import retrofit2.Call
import retrofit2.http.*

interface ApiServerProfe {

    @GET("profesor.php")

    fun obtenerProfesor():
            Call<List<Profesor>>

    @GET("profesor/{id}")

    fun obtenerProfesoPorId(@Path("id") id: Int):
            Call<Profesor>

    @POST("profesor")
    fun crearProfesor(@Body profesor: Profesor): Call<Profesor>


    @PUT("profesor/{id}")
    fun actualizarProfesor(@Path("id") id: Int, @Body profesor: Profesor ):
            Call<Profesor>

    @PUT("alumno/{id}")
    fun eliminarProfesor(@Path("id") id: Int, @Body profesor: Profesor):
            Call<Void>
}