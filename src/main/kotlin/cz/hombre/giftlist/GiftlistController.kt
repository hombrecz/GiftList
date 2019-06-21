package cz.hombre.giftlist

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Giftlist(val owner: String, val gifts: String)

@RestController
class GiftlistController {

    @RequestMapping("/giftlist")
    fun giftlist(): Giftlist {
        return Giftlist("Hombre", "whisky, books")
    }
}