package cz.hombre.giftlist.dto

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity

@Entity
data class Gift(val descripton: String, var price: Int = 0, var buyer: String = "")