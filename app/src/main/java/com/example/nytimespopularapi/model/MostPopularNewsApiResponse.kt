package com.example.nytimespopularapi.model


import com.google.gson.annotations.SerializedName

data class MostPopularNewsApiResponse(
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("num_results")
    var numResults: Int? = null,
    @SerializedName("results")
    var results: List<Result?>? = null,
    @SerializedName("status")
    var status: String? = null
) {
    data class Result(
        @SerializedName("abstract")
        var `abstract`: String? = null,
        @SerializedName("adx_keywords")
        var adxKeywords: String? = null,
        @SerializedName("asset_id")
        var assetId: Long? = null,
        @SerializedName("byline")
        var byline: String? = null,
        @SerializedName("column")
        var column: Any? = null,
        @SerializedName("des_facet")
        var desFacet: List<String?>? = null,
        @SerializedName("eta_id")
        var etaId: Int? = null,
        @SerializedName("geo_facet")
        var geoFacet: List<String?>? = null,
        @SerializedName("id")
        var id: Long? = null,
        @SerializedName("media")
        var media: List<Media?>? = null,
        @SerializedName("nytdsection")
        var nytdsection: String? = null,
        @SerializedName("org_facet")
        var orgFacet: List<String?>? = null,
        @SerializedName("per_facet")
        var perFacet: List<String?>? = null,
        @SerializedName("published_date")
        var publishedDate: String? = null,
        @SerializedName("section")
        var section: String? = null,
        @SerializedName("source")
        var source: String? = null,
        @SerializedName("subsection")
        var subsection: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("type")
        var type: String? = null,
        @SerializedName("updated")
        var updated: String? = null,
        @SerializedName("uri")
        var uri: String? = null,
        @SerializedName("url")
        var url: String? = null
    ) {
        data class Media(
            @SerializedName("approved_for_syndication")
            var approvedForSyndication: Int? = null,
            @SerializedName("caption")
            var caption: String? = null,
            @SerializedName("copyright")
            var copyright: String? = null,
            @SerializedName("media-metadata")
            var mediaMetadata: List<MediaMetadata?>? = null,
            @SerializedName("subtype")
            var subtype: String? = null,
            @SerializedName("type")
            var type: String? = null
        ) {
            data class MediaMetadata(
                @SerializedName("format")
                var format: String? = null,
                @SerializedName("height")
                var height: Int? = null,
                @SerializedName("url")
                var url: String? = null,
                @SerializedName("width")
                var width: Int? = null
            )
        }
    }
}