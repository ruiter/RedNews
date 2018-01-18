package com.ruiter.posts.list.presentation.mapper

import com.ruiter.posts.list.domain.models.*
import com.ruiter.posts.list.presentation.model.*

fun PostsListBusinness.toPostsList() : PostsList {
    return PostsList(kind, dataBusinness.toChildren())
}

fun DataBusinness.toChildren() : Data {
    return Data(whitelistStatus, toMutableListDataParent(), after)
}

fun DataBusinness.toMutableListDataParent() : MutableList<Children> {
    return childrenResponse.map {
        it.toDataParent()
    }.toMutableList()
}

fun ChildrenBusinness.toDataParent() : Children {
    return Children(dataChildren.toDataChildren())
}

fun DataChildrenBusinness.toDataChildren() : DataChildren {
    return DataChildren(title, thumbnail, author, url, likes, comments, preview?.toPreview())
}

fun PreviewBusinnes.toPreview() : Preview {
    return Preview(toListImages())
}

fun ImagesBusinnes.toImages() : Images {
    return Images(source.toSource(), toListResolutions())
}

fun PreviewBusinnes.toListImages() : MutableList<Images> {
    return images.map {
        it.toImages()
    }.toMutableList()
}

fun SourceBusinnes.toSource() : Source {
    return Source(url, width, height)
}

fun ResolutionsBusinnes.toResolutios() : Resolutions {
    return Resolutions(url, width, height)
}

fun ImagesBusinnes.toListResolutions() : MutableList<Resolutions> {
    return resolutions.map {
        it.toResolutios()
    }.toMutableList()
}