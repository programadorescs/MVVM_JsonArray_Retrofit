package pe.pcs.mvvm_jsonarray_retrofit.data.model

import com.google.gson.annotations.SerializedName

data class GeoModel(
    @SerializedName("lat") var lat: Double,
    @SerializedName("lng") var lng: Double
)
