package cz.hombre.giftlist.service

import cz.hombre.giftlist.dto.GiftList

interface GiftListService : EntityService<GiftList> {

    fun addGift(owner: String, giftName: String): GiftList

    fun removeGift(owner: String, giftName: String): GiftList

    fun reserveGift(owner: String, giftName: String, buyer: String): GiftList

    fun findByOwner(owner: String): GiftList

}