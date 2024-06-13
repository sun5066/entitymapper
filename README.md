# EntityMapper

[![](https://jitpack.io/v/sun5066/entitymapper.svg)](https://jitpack.io/#sun5066/entitymapper)

- `@EntityMapper` is an annotation that maps an entity class to a model class.
- `@PropertyName` is an annotation that maps a field in the entity class to a field with a different name in the model class.

## Sample Code
```
data class MemberEntity(
  val id: Int? = null,
  val name: String? = null,
  val age: Int? = null,
  val thumbnailUrl: String? = null,
  val collectionList: List<CollectionEntity>? = null,
  private val subscribeYn: String? = null
) {
  val isSubscribe: Boolean
    get() = subscribeYn.equals("y", true) == true
}

@EntityMapper(MemberEntity::class)
data class MemberUiModel(
  val id: Int,
  val name: String,
  val age: Int,
  val thumbnailUrl: String?,
  @PropertyName(["collectionList"]) val collections: List<CollectionModel>,
  val isSubscribe: Boolean
)
```

1. `@EntityMapper` annotation usage
2. Build the module or project using the following command

```
./gradlew :model:build or ./gradlew rebuild
```

If the build is successful, the following code will be generated.

```
fun MemberEntity.toMemberUiModel() = MemberUiModel(
  id = id!!,
  name = name!!,
  age = age!!,
  thumbnailUrl = thumbnailUrl,
  collections = collectionList?.map { it.toCollectionModel() } ?: emptyList(),
  isSubscribe = isSubscribe
)
```

## Using in your projects

Add the KSP Gradle Plugin build.gradle(.kts)

```
plugin {
  id("com.google.devtools.ksp").version("1.9.24-1.0.20")
}

dependencies {
  implementation("com.github.sun5066:entitymapper:tag")
  ksp("com.github.sun5066:entitymapper:tag")
}
```

add to setting.gradle(.kts)

```
repositories {
  maven("https://jitpack.io")
}
```
