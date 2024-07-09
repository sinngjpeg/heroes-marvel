package br.com.sinngjpeg.marvelapp.framework.network.response

data class DataWrapperResponse<T>(
    val copyright: String,
    val data: DataContainerResponse<T>
)
