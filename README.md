# News Hacks

A trivial playground app that uses Compose Multiplatofm to fetch RSS feed on the newest posts on Hacker News via [Hacker New RSS](https://hnrss.github.io).

<div style="display:flex;" >
<img src="https://github.com/vshkl/News-Hacks/blob/main/screenshots/screenshot-android.png" width="15%" >
<img src="https://github.com/vshkl/News-Hacks/blob/main/screenshots/screenshot-macos.png" width="55%" >
<img src="https://github.com/vshkl/News-Hacks/blob/main/screenshots/screenshot-ios.png" width="15%" >
</div>

## Stack

- Compose Multiplatform
- Ktor
- SqlDelight
- KotlinX Serialization
- Xmlutil
- Detekt

## Problems

### XML parsing

There is no Kotlinx Seriaization implementation that works with XML for all targets – onlt for JVM, therefore it's needed to write a custom [XMLConverted](https://github.com/vshkl/News-Hacks/blob/main/composeApp/src/commonMain/kotlin/com/vshkl/newshacks/di/XMLConverter.kt) and [register](https://github.com/vshkl/News-Hacks/blob/main/composeApp/src/commonMain/kotlin/com/vshkl/newshacks/di/CommonModule.kt) it inside Content Negotiation plugin for Ktor.

### RFC 822 date

Kotlix Datetime library does not have suport for RFC 822 dates out of the box. Potentially, it is possible to implement some soft of `rfc822toISO8601` function that is marked as `expect` in the common module and hasve `actual` implementations in all targets and use KotlinX Datetime library from that point onwards. I imagine this coversion should happen at the very "edge" of the app, at API level.

### Depencency injection

Awkward. I tried Kodein and failed miserably while trying to provide a SQL drivers for each target. The main caveat was that for Android I need Context, and there was no straightforward way to provide one implementation with additional parameter. I mean, there are options, but they look funny. Koin is fine, though, but after all the fun with Kodein I decided to just povide "modules" manually:

There is a platform module where everything platform specific will go:
```Kotlin
expect class PlatformModule {

    val sqlDriver: SqlDriver
}
```

and a common module that is self-explanatory:
```Kotlin
class CommonModule {

    val httpClient: HttpClient = ...
}
```

This is by no means a scalable solution, but for the same of this app – it was just fine. Potentially, it is possible to use `CompositionLocal` to make it look a bit less ugly, though I'm still not shure thether or now it is a good idea.

## About Compose Multiplatform

This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

[MIT Licence](https://github.com/vshkl/News-Hacks/blob/LICENCE.md)
