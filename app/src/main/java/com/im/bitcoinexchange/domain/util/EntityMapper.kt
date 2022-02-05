package com.im.bitcoinexchange.domain.util

interface EntityMapper<Entity, Model>{


    fun mapTo(entity: Entity): Model

    fun mapFrom(model: Model): Entity

}