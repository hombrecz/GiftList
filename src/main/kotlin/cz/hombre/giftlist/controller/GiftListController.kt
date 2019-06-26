package cz.hombre.giftlist.controller

import cz.hombre.giftlist.dto.Gift
import cz.hombre.giftlist.dto.GiftList
import cz.hombre.giftlist.repository.GiftListRepository
import org.springframework.web.bind.annotation.*

@RestController
class GiftListController(private val giftListRepository: GiftListRepository) {

    @GetMapping("/giftList/{owner}")
    fun getGiftList(@PathVariable owner: String): GiftList {

        return giftListRepository.findByOwner(owner).get(0)
    }

    @PostMapping("/giftList")
    fun createGiftList(@RequestParam("owner") owner: String): GiftList {
        val giftList = GiftList(owner)

        return giftListRepository.save(giftList)
    }

    @GetMapping("/giftList")
    fun getAllGiftLists(): MutableCollection<GiftList> {
        val allGiftLists: MutableCollection<GiftList> = mutableListOf()

        return giftListRepository.findAll().toCollection(allGiftLists)
    }

    @PostMapping("/giftList/{owner}")
    fun addGift(@PathVariable owner: String, @RequestParam("gift") giftName: String): GiftList {
        val giftList = this.getGiftList(owner)

        val gift = Gift(giftName)

        giftList.gifts.add(gift)

        return giftListRepository.save(giftList)
    }

    @PutMapping("/giftList/{owner}/{giftName}")
    fun reserveGift(@PathVariable owner: String, @PathVariable giftName: String, @RequestParam("buyer") buyer: String): GiftList {
        val giftList = this.getGiftList(owner)
        val gift = giftList.gifts.find { g -> g.descripton.equals(giftName) }

        gift?.buyer = buyer

        giftList.gifts.remove(gift)

        giftList.gifts.add(gift ?: Gift(giftName, buyer = buyer))

        return giftListRepository.save(giftList)
    }

    @DeleteMapping("/giftList/{owner}/{giftName}")
    fun deleteGift(@PathVariable owner: String, @PathVariable giftName: String): GiftList {
        val giftList = this.getGiftList(owner)
        val gift = giftList.gifts.find { g -> g.descripton.equals(giftName) }

        giftList.gifts.remove(gift)

        giftListRepository.save(giftList)

        return giftList
    }
}