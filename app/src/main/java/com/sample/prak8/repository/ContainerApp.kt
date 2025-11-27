package com.sample.prak8.repository

import android.content.Context
import com.sample.prak8.data.DatabaseSiswa
import com.sample.prak8.repositori.RepositoriSiswa
import com.sample.prak8.repositori.OfflineRepositoriSiswa

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            siswaDao = DatabaseSiswa.getDatabase(context).siswaDao()
        )
    }
}

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(context = this)
    }
}