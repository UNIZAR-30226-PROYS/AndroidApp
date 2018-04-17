package com.spreadyourmusic.spreadyourmusic.models

import android.graphics.Bitmap
import java.util.*

/**
 * Created by abel
 * On 7/03/18.
 */
// TODO:
class User() : Recommendation {
    var username: String? = null
    var name: String? = null
    var pictureLocationUri: String? = null
    var bibliography: String? = null
    var email: String? = null
    var password: String? = null
    var birthDate: Date? = null
    //String locale = context.getResources().getConfiguration().locale.getCountry();
    var country: String? = null
    var twitterAccount: String? = null
    var facebookAccount: String? = null
    var instagramAccount: String? = null
    var picture:Bitmap? = null

    constructor(username: String, password: String): this(){
        this.username = username
        this.password = password
    }

    constructor(username: String, name: String, email: String, pictureLocationUri: String): this(){
        this.username = username
        this.name = name
        this.email = email
        this.pictureLocationUri = pictureLocationUri
    }

    fun getTwitterAccountURL() : String?{
        return if(twitterAccount != null) "https://twitter.com/$twitterAccount"
        else null
    }

    fun getFacebookAccountURL(): String?{
        return if(facebookAccount != null) "https://www.facebook.com/$facebookAccount"
        else null
    }

    fun getInstagramAccountURL(): String?{
        return if(instagramAccount != null) "https://www.instagram.com/$instagramAccount"
        else null
    }

    fun getShareLink(): String{
        //TODO: El link devuelto ha de ser el que apunta al mismo usuario desde la interfaz web
        return "https://www.google.es/"
    }
}