package cz.hombre.giftlist.service


interface EntityService<T> {

    fun save(entity: T): T

    fun getAll(): List<T>
}