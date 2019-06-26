package cz.hombre.giftlist.dto

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id

@Entity
data class GiftList(val owner: String, val gifts: MutableList<Gift> = mutableListOf(), @Id var id: Long? = null) {

    fun sortGifts(): GiftList {
        this.gifts.sortBy { it.descripton }

        return this
    }

}