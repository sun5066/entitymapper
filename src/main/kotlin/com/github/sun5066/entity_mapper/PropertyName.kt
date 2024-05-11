package com.github.sun5066.entity_mapper

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class PropertyName(val aliases: Array<String> = [])
