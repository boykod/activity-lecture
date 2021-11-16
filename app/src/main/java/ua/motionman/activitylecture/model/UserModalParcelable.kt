package ua.motionman.activitylecture.model

import android.os.Parcel
import android.os.Parcelable

data class UserModalParcelable(
    val id: String,
    val firstName: String,
    val lastName: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModalParcelable> {
        override fun createFromParcel(parcel: Parcel): UserModalParcelable {
            return UserModalParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UserModalParcelable?> {
            return arrayOfNulls(size)
        }
    }
}