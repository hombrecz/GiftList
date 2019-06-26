package cz.hombre.giftlist.service

import cz.hombre.giftlist.dto.GiftList

interface GiftListService {

    fun save(giftList: GiftList): GiftList //TODO OD common

    fun getAll(): MutableCollection<GiftList> //TODO OD common

    fun addGift(owner: String, giftName: String): GiftList

    fun removeGift(owner: String, giftName: String): GiftList

    fun reserveGift(owner: String, giftName: String, buyer: String): GiftList

    fun findByOwner(owner: String): GiftList

}

// TODO OD - let the impl inherit from EntityService class
// TODO OD - return all the gifts sorted by name and giftlists sorted by owner name