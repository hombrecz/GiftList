package cz.hombre.giftlist.repository

import cz.hombre.giftlist.dto.GiftList
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository
import org.springframework.stereotype.Repository

@Repository
interface GiftListRepository : DatastoreRepository<GiftList, Long> {

    fun findByOwner(owner: String): List<GiftList>
}