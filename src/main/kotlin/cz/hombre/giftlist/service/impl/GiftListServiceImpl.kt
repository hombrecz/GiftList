package cz.hombre.giftlist.service.impl

import cz.hombre.giftlist.dto.Gift
import cz.hombre.giftlist.dto.GiftList
import cz.hombre.giftlist.repository.GiftListRepository
import cz.hombre.giftlist.service.GiftListService
import org.springframework.stereotype.Service

@Service
class GiftListServiceImpl(private val giftListRepository: GiftListRepository) : GiftListService {

    companion object {
        const val FIRST_VALUE = 0
    }

    override fun save(giftList: GiftList): GiftList {

        return giftListRepository.save(giftList)
    }

    override fun getAll(): MutableCollection<GiftList> {
        val allGiftLists: MutableCollection<GiftList> = mutableListOf()

        return giftListRepository.findAll().toCollection(allGiftLists)
    }

    override fun addGift(owner: String, giftName: String): GiftList {
        val giftList = findByOwner(owner)

        val gift = Gift(giftName)

        giftList.gifts.add(gift)

        return save(giftList)
    }

    override fun removeGift(owner: String, giftName: String): GiftList {
        val giftList = findByOwner(owner)
        val gift = giftList.gifts.find { g -> g.descripton == giftName }

        giftList.gifts.remove(gift)

        save(giftList)

        return giftList
    }

    override fun reserveGift(owner: String, giftName: String, buyer: String): GiftList {
        val giftList = findByOwner(owner)
        val gift = giftList.gifts.find { g -> g.descripton == giftName }

        gift?.buyer = buyer

        giftList.gifts.remove(gift)

        giftList.gifts.add(gift ?: Gift(giftName, buyer = buyer))

        return save(giftList)
    }

    override fun findByOwner(owner: String): GiftList {

        return giftListRepository.findByOwner(owner)[FIRST_VALUE]
    }
}