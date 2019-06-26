package cz.hombre.giftlist.controller

import cz.hombre.giftlist.dto.GiftList
import cz.hombre.giftlist.service.GiftListService
import org.springframework.web.bind.annotation.*

@RestController
class GiftListController(private val giftListService: GiftListService) {

    @GetMapping("/giftList/{owner}")
    fun getGiftList(@PathVariable owner: String) = giftListService.findByOwner(owner)

    @PostMapping("/giftList")
    fun createGiftList(@RequestParam("owner") owner: String): GiftList = giftListService.save(GiftList(owner))

    @GetMapping("/giftList")
    fun getAllGiftLists(): List<GiftList> = giftListService.getAll()

    @PostMapping("/giftList/{owner}")
    fun addGift(@PathVariable owner: String, @RequestParam("gift") giftName: String) = giftListService.addGift(owner, giftName)

    @PutMapping("/giftList/{owner}/{giftName}")
    fun reserveGift(@PathVariable owner: String, @PathVariable giftName: String, @RequestParam("buyer") buyer: String) = giftListService.reserveGift(owner, giftName, buyer)

    @DeleteMapping("/giftList/{owner}/{giftName}")
    fun removeGift(@PathVariable owner: String, @PathVariable giftName: String) = giftListService.removeGift(owner, giftName)
}