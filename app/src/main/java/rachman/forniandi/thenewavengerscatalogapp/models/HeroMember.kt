package rachman.forniandi.thenewavengerscatalogapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroMember(
    val image:Int?,
    val name:String?,
    val alias:String?,
    val description:String?,
    val powers:String?,
    val abilities:String?
): Parcelable
