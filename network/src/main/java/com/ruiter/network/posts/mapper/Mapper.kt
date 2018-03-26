package com.ruiter.network.posts.mapper

import com.ruiter.network.posts.models.*
import com.ruiter.posts.list.data.models.*

/**
 * Created by ruitermatos on 26/03/18.
 */
fun DataRemote.toChildrenResponse() : DataResponse {
    return DataResponse(whitelistStatus, toMutableListDataParentBusinnes(), after)
}

fun DataRemote.toMutableListDataParentBusinnes() : MutableList<ChildrenResponse> {
    return childrenRemote.map {
        it.toDataParentResponse()
    }.toMutableList()
}

fun ChildrenRemote.toDataParentResponse() : ChildrenResponse {
    return ChildrenResponse(dataChildren.toDataChildrenResponse())
}

fun DataChildrenRemote.toDataChildrenResponse() : DataChildrenResponse {
    return DataChildrenResponse(title, thumbnail, author, url, likes, comments,
            preview?.toPreviewResponse())
}

fun PreviewRemote.toPreviewResponse() : PreviewResponse {
    return PreviewResponse(toListImagesResponse())
}

fun ImagesRemote.toImagesResponse() : ImagesResponse {
    return ImagesResponse(source.toSourceResponse(), toListResolutionsResponse())
}

fun PreviewRemote.toListImagesResponse() : MutableList<ImagesResponse> {
    return images.map {
        it.toImagesResponse()
    }.toMutableList()
}

fun SourceRemote.toSourceResponse() : SourceResponse {
    return SourceResponse(url, width, height)
}

fun ResolutionsRemote.toResolutiosResponse() : ResolutionsResponse {
    return ResolutionsResponse(url, width, height)
}

fun ImagesRemote.toListResolutionsResponse() : MutableList<ResolutionsResponse> {
    return resolutions.map {
        it.toResolutiosResponse()
    }.toMutableList()
}