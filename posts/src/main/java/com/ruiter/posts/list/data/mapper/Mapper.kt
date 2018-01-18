package com.ruiter.posts.list.data.mapper

import com.ruiter.posts.list.data.models.*
import com.ruiter.posts.list.domain.models.*

fun PostsListResponse.toPostsListBusinness() : PostsListBusinness {
    return PostsListBusinness(kind, dataResponse.toChildrenBusinness())
}

fun DataResponse.toChildrenBusinness() : DataBusinness {
    return DataBusinness(whitelistStatus, toMutableListDataParentBusinnes(), after)
}

fun DataResponse.toMutableListDataParentBusinnes() : MutableList<ChildrenBusinness> {
    return childrenResponse.map {
        it.toDataParentBusinnes()
    }.toMutableList()
}

fun ChildrenResponse.toDataParentBusinnes() : ChildrenBusinness {
    return ChildrenBusinness(dataChildren.toDataChildrenBusinness())
}
fun DataChildrenResponse.toDataChildrenBusinness() : DataChildrenBusinness {
    return DataChildrenBusinness(title, thumbnail, author, url, likes, comments,
            preview?.toPreviewBusiness())
}

fun PreviewResponse.toPreviewBusiness() : PreviewBusinnes {
    return PreviewBusinnes(toListImagesBusiness())
}

fun ImagesResponse.toImagesBusiness() : ImagesBusinnes {
    return ImagesBusinnes(source.toSourceBusiness(), toListResolutionsBusiness())
}

fun PreviewResponse.toListImagesBusiness() : MutableList<ImagesBusinnes> {
    return images.map {
        it.toImagesBusiness()
    }.toMutableList()
}

fun SourceResponse.toSourceBusiness() : SourceBusinnes {
    return SourceBusinnes(url, width, height)
}

fun ResolutionsResponse.toResolutiosBusiness() : ResolutionsBusinnes {
    return ResolutionsBusinnes(url, width, height)
}

fun ImagesResponse.toListResolutionsBusiness() : MutableList<ResolutionsBusinnes> {
    return resolutions.map {
        it.toResolutiosBusiness()
    }.toMutableList()
}