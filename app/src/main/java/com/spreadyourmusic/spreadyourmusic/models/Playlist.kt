/**
 * Created by abel
 * On 7/03/18.
 */
package com.spreadyourmusic.spreadyourmusic.models

/**
 * Constructor usado cuando se generan datos desde el dispositivo
 */
class Playlist(val name: String, val creator: User, val artLocationUri: String, val content: List<Song>) : Recommendation {
    var id: Long? = null

    //TODO: El link devuelto ha de ser el que apunta a la misma playlist desde la interfaz web
    override var shareLink: String = "http://155.210.13.105:8006/playlist?type=playlist&id=$id"

    /**
     * Constructor usado cuando se obtienen datos desde el back-end
     */
    constructor(id: Long, name: String, creator: User, artLocationUri: String, content: List<Song>) : this(name, creator, artLocationUri, content) {
        this.id = id
        this.shareLink = shareLink + id.toString() + "/"
    }
}