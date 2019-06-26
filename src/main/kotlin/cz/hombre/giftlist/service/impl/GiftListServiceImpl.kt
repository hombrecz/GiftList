package cz.hombre.giftlist.service.impl

import cz.hombre.giftlist.Constants.Companion.FIRST_VALUE
import cz.hombre.giftlist.dto.Gift
import cz.hombre.giftlist.dto.GiftList
import cz.hombre.giftlist.repository.GiftListRepository
import cz.hombre.giftlist.service.GiftListService
import org.springframework.stereotype.Service

@Service
class GiftListServiceImpl(private val giftListRepository: GiftListRepository) : GiftListService {


    override fun save(entity: GiftList) = giftListRepository
            .save(entity)
            .sortGifts()

    override fun getAll(): List<GiftList> {
        val allGiftLists: MutableCollection<GiftList> = mutableListOf()

        return giftListRepository
                .findAll()
                .toCollection(allGiftLists)
                .sortedBy { it.owner }
    }

    override fun addGift(owner: String, giftName: String): GiftList {
        val giftList = findByOwner(owner)

        val gift = Gift(giftName)

        giftList.gifts.add(gift)

        return save(giftList)
                .sortGifts()
    }

    override fun removeGift(owner: String, giftName: String): GiftList {
        val giftList = findByOwner(owner)
        val gift = giftList.gifts.find { g -> g.descripton == giftName }

        giftList.gifts.remove(gift)

        save(giftList)

        return giftList
                .sortGifts()
    }

    override fun reserveGift(owner: String, giftName: String, buyer: String): GiftList {
        val giftList = findByOwner(owner)
        val gift = giftList.gifts.find { g -> g.descripton == giftName }

        gift?.buyer = buyer

        giftList.gifts.remove(gift)

        giftList.gifts.add(gift ?: Gift(giftName, buyer = buyer))

        return save(giftList)
                .sortGifts()
    }

    override fun findByOwner(owner: String) = giftListRepository
            .findByOwner(owner)[FIRST_VALUE]
            .sortGifts()
}