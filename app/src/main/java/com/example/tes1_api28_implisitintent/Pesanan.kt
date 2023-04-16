package com.example.tes1_api28_implisitintent

import android.os.Parcel
import android.os.Parcelable

data class Pesanan (
    val Jumlah : Int,
    val Topping : String?,
    val Harga : Int
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    )
    
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Jumlah)
        parcel.writeString(Topping)
        parcel.writeInt(Harga)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pesanan> {
        override fun createFromParcel(parcel: Parcel): Pesanan {
            return Pesanan(parcel)
        }

        override fun newArray(size: Int): Array<Pesanan?> {
            return arrayOfNulls(size)
        }
    }
}