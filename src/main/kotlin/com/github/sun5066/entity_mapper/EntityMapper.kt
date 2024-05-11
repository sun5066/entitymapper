package com.github.sun5066.entity_mapper

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class EntityMapper(val fromClass: KClass<*>)
