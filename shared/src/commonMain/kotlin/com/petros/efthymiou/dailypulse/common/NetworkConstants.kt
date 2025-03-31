package com.petros.efthymiou.dailypulse.common

object NetworkConstants {
    private const val SCHEME = "https://"
    private const val HOST = "newsapi.org"
    private const val ARTICLES_PATH = "/v2/top-headlines"
    private const val SOURCES_PATH = "/v2/top-headlines/sources"
    private const val DEFAULT_ARTICLE_IMAGE = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"

    const val apiKey = "0aa496cd483d425ebb3e70663da6a070"

    fun getArticlesUrl(): String {
        return SCHEME + HOST + ARTICLES_PATH
    }

    fun getSourcesUrl(): String {
        return SCHEME + HOST + SOURCES_PATH
    }

    fun getDefaultArticleImageUrl(): String {
        return DEFAULT_ARTICLE_IMAGE
    }
}