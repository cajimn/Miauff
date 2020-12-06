package com.example.appet

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

abstract class Mascota(propietario: String, nombre: String, sexo: String, raza: String, colorPelo: String, peso : Double, edad:Int) {
    var propietario : String = propietario
    var nombre : String = nombre
    var sexo : String = sexo
    var raza : String = raza
    var colorPelo : String = colorPelo
    var peso: Double = peso
    var edad : Int = edad
    var tipo : String = ""

    fun savePrincipalInfo( tipoPet:String){
        val db = FirebaseFirestore.getInstance()
        val tipo = tipoPet

        val data = hashMapOf("nombreMascota" to nombre, "genero" to sexo, "raza" to raza,"colorPelo" to colorPelo,"peso" to peso, "edad" to edad )
        db.collection("mascota").document(propietario ?: "").collection(tipo).document(nombre?: "").set(
            data , SetOptions.merge()
        )
    }

    abstract fun saveInformation()

}