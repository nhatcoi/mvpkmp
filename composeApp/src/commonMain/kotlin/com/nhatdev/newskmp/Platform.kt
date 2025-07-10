package com.nhatdev.newskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform