package com.example.qrcodeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.qrcodeapp.model.DatabaseModel
import java.sql.ResultSet

class DatabaseViewModel : ViewModel() {
    private val model = DatabaseModel()

    fun connectToDatabase(url: String, user: String, password: String): Boolean {
        return model.connectToDatabase(url, user, password)
    }

    fun executeSelectQuery(query: String): ResultSet? {
        return model.executeSelectQuery(query)
    }

    fun executeUpdateQuery(query: String): Int {
        return model.executeUpdateQuery(query)
    }

    override fun onCleared() {
        super.onCleared()
        model.disconnectFromDatabase()
    }
}