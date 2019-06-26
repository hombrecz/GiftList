package cz.hombre.giftlist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class GiftListApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<GiftListApplication>(*args)
}

//TODO OD - try "object mapper" -> entity serialize automatically https://github.com/Kotlin/kotlinx.serialization