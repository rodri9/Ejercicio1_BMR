package com.androiddgsa.ejercicio_1_bmr.data

import android.os.Parcel
import android.os.Parcelable

data class ReservaData(
    val nombres: String,
    val apellidos: String,
    val email: String,
    val origen: String,
    val destino: String,
    val fechaSalida: String,
    val fechaRegreso: String,
    val numCliente: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombres)
        parcel.writeString(apellidos)
        parcel.writeString(email)
        parcel.writeString(origen)
        parcel.writeString(destino)
        parcel.writeString(fechaSalida)
        parcel.writeString(fechaRegreso)
        parcel.writeString(numCliente)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ReservaData> {
        override fun createFromParcel(parcel: Parcel): ReservaData {
            return ReservaData(parcel)
        }

        override fun newArray(size: Int): Array<ReservaData?> {
            return arrayOfNulls(size)
        }
    }
}
