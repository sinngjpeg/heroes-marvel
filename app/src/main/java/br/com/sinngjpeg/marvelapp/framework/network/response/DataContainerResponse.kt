package br.com.sinngjpeg.marvelapp.framework.network.response

data class DataContainerResponse<T>(
    val offset: Int,
    val total: Int,
    val results: List<T>
)
