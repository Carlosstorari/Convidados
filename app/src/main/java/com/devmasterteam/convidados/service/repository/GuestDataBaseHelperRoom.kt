package com.devmasterteam.convidados.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devmasterteam.convidados.service.model.GuestModel

//define quais entidades e versão o banco de dados vai usar
@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBaseHelperRoom : RoomDatabase() {

    companion object {
        private lateinit var  INSTANCE:  GuestDataBaseHelperRoom
        fun getDataBase(context: Context): GuestDataBaseHelperRoom {

            //verifica se banco foi inicializado
            if (!::INSTANCE.isInitialized){
                synchronized(GuestDataBaseHelperRoom::class) { // synchronized não deixa executar o mesmo código em duas threads
                    INSTANCE =  Room.databaseBuilder(context, GuestDataBaseHelperRoom::class.java, "guestdb")
                        .build()
                }
            }

            return INSTANCE

        }
    }
}