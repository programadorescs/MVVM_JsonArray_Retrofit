package pe.pcs.mvvm_jsonarray_retrofit.data.model

import com.google.gson.annotations.SerializedName

data class AddresModel(
    @SerializedName("street") var street: String,
    @SerializedName("city") var city: String,
    @SerializedName("suite") var suite: String,
    @SerializedName("zipcode") var zipcode: String,
    @SerializedName("geo") var geo: GeoModel
)
