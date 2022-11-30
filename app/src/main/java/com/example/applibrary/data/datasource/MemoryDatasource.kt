package com.example.applibrary.data.datasource

import com.example.applibrary.R
import com.example.applibrary.data.models.CompanyModel
import com.example.applibrary.data.models.LibroItemModel
import com.example.applibrary.data.models.ServiceItemModel

class MemoryDatasource {

    fun services(): List<ServiceItemModel>{
        return listOf(
            ServiceItemModel(
                "1","Aventura","Es un género narrativo literario que narra los viajes, el misterio y el riesgo",
                R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "2","Ciencia Ficcion","Es un género narrativo literario que narra la ficcion, la literatura fantastica y el terror",
                R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "3","Fantasia","Es un género narrativo literario que narra la fantasia",
                R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "4","Romantico","Es un género narrativo literario que narra lo dulce del amor y la pasion",
                R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "5","Infantil y Juvenil","Es un género narrativo literario que narra las obras de creación para niños y jóvenes",
                R.drawable.logins.toString()
            )
        )
    }

    fun company(): CompanyModel{
        return  CompanyModel("1","Magic Books",4.647655645472472, -74.10098132134)
    }

    fun libros(): List<LibroItemModel>{
        return listOf(
            LibroItemModel("1", "La isla del tesoro", "Aventura", R.drawable.ic_baseline_book_24.toString(), 1, "narra una aventura de un tiempo lejano, en el que todavía había piratas y tesoros escondidos en islas desiertas."),
            LibroItemModel("2", "La máquina del tiempo", "Ciencia Ficcion", R.drawable.ic_baseline_book_24.toString(), 1, "Un científico inventa una máquina para viajar a través del tiempo."),
            LibroItemModel("3", "El faro del fin del mundo", "Aventura", R.drawable.ic_baseline_book_24.toString(), 1, "Tres guardianes son designados para cuidar un nuevo faro situado en Staten Island"),
            LibroItemModel("4", "En las montañas de la locura", "Ciencia Ficcion", R.drawable.ic_baseline_book_24.toString(), 1, "Narra la expedición desastrosa que realizan unos grupo de expertos a la Antártida"),
            LibroItemModel("5", "El ruiseñor", "Romantico", R.drawable.ic_baseline_book_24.toString(), 1, "Presenta una historia muy emotiva que trata temas como el amor, la supervivencia y la libertad, a través de la mirada de dos mujeres que lucharon contra el nazismo."),
            LibroItemModel("6", "El nombre del viento", "Fantasia", R.drawable.ic_baseline_book_24.toString(), 1, "El nombre del viento. Crónica del asesino de reyes: primer día es una novela de fantasía épica, perteneciente a la serie Crónica del Asesino de Reyes, escrita por Patrick Rothfuss"),
            LibroItemModel("7", "Hansel y Gretel", "Infantil y Juvenil", R.drawable.ic_baseline_book_24.toString(), 1, "Hansel y Gretel es un cuento de hadas alemán recogido por los hermanos Grimm y publicado en 1812"),
            LibroItemModel("8", "Caperucita Roja", "Infantil y Juvenil", R.drawable.ic_baseline_book_24.toString(), 1, "Caperucita Roja es un cuento de hadas de transmisión oral, difundido por gran parte de Europa"),
            LibroItemModel("9", "Una corte de rosas y espinas", "Fantasia", R.drawable.ic_baseline_book_24.toString(), 1, "Feyre está desesperada, su vida y la de su familia dependen de ella. Enfrentada al hambre más absoluto, no dudará en ir al bosque prohibido y matar si es necesario")
        )
    }
}