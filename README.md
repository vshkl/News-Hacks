# News Hacks

A trivial playground app that uses Compose Multiplatofm to fetch RSS feed on the newest posts on Hacker News via [Hacker New RSS](https://hnrss.github.io).

<div style="display:flex;" >
<img src="https://github.com/vshkl/News-Hacks/blob/main/screenshots/screenshot-android.png" width="15%" >
<img src="https://github.com/vshkl/News-Hacks/blob/main/screenshots/screenshot-macos.png" width="55%" >
<img src="https://github.com/vshkl/News-Hacks/blob/main/screenshots/screenshot-ios.png" width="15%" >
</div>

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
