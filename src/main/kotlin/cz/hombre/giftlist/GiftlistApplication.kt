package cz.hombre.giftlist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class GiftlistApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<GiftlistApplication>(*args)
}
