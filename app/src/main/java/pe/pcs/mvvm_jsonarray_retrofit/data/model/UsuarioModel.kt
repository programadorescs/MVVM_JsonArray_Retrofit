package pe.pcs.mvvm_jsonarray_retrofit.data.model

import com.google.gson.annotations.SerializedName

data class UsuarioModel(
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("username") var username : String,
    @SerializedName("email") var email : String,
    @SerializedName("address") var address: AddresModel,
    @SerializedName("phone") var phone : String,
    @SerializedName("website") var website : String,
    @SerializedName("company") var company: CompanyModel
)