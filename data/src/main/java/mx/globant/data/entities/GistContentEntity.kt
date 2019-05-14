package mx.globant.data.entities

import com.google.gson.annotations.SerializedName

data class GistContentEntity(
    @SerializedName(value = "personal.json", alternate = ["skills.json", "workhistory.json"])
    val rootFile: GistFileEntity
)