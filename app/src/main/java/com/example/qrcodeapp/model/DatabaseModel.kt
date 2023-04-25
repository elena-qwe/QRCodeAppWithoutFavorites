package com.example.qrcodeapp.model

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class DatabaseModel {
    private var connection: Connection? = null

    fun connectToDatabase(url: String, user: String, password: String): Boolean {
        try {
            Class.forName("com.mysql.jdbc.Driver")
            connection = DriverManager.getConnection(url, user, password)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    fun executeSelectQuery(query: String): ResultSet? {
        return try {
            val statement = connection?.createStatement()
            statement?.executeQuery(query)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun executeUpdateQuery(query: String): Int {
        return try {
            val statement = connection?.createStatement()
            statement?.executeUpdate(query) ?: 0
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    fun disconnectFromDatabase() {
        try {
            connection?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}