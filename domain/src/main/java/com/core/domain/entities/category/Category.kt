package com.core.domain.entities.category

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey
    var categoryId: Int = 0,

    var rosId: Int = 0,
    var retailerId: Int = 0,
    var name: String? = "",
    var logo: String? = "",
    var desc: String? = "",
    var availability: Boolean = false,
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel){
        parcel.writeInt(categoryId)
        parcel.writeInt(rosId)
        parcel.writeInt(retailerId)
        parcel.writeString(name)
        parcel.writeString(logo)
        parcel.writeString(desc)
        parcel.writeByte(if (availability) 1 else 0)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }

}
