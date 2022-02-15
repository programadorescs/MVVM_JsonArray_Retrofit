package pe.pcs.mvvm_jsonarray_retrofit.data.model

import com.google.gson.annotations.SerializedName

data class CompanyModel(
    @SerializedName("name") var name: String,
    @SerializedName("catchPhrase") var catchPhrase: String,
    @SerializedName("bs") var bs: String
)
