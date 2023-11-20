package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "puntuazioak",
        foreignKeys = @ForeignKey(
                entity = Erabiltzaile.class,
                parentColumns = "id",
                childColumns = "erabiltzaileId",
                onDelete = ForeignKey.CASCADE
        )
)
public class Puntuazioa {
    @PrimaryKey
    @ColumnInfo(name = "puntuazioa")
    public int puntuazioa;

    @ColumnInfo(name = "erabiltzaileId")
    public int erabiltzaileId; // Este campo actúa como clave externa (fk)
}
