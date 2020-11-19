<h1 align="center">Super Heroes</h1></br>
<p align="center">
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen"/></a>
  <a href="https://github.com/jslowinski"><img alt="Profile" src="https://jslowinski.github.io/Website/badges/jslowinski.svg"/></a> 
</p>

Super Heroes is a simple small application that loads infromation from [SuperHero API](https://superheroapi.com) and persisted data in the database via repository pattern.
App uses modern tech-stacks and MVVM architecture. 

</br>
<p align="center">
<img src="/previews/screenshot.png"/>
</p>


## Tech stack & Open-source libraries
- [Kotlin](https://kotlinlang.org/) based
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for asynchronous.
- [JetPack Architecture](https://developer.android.com/topic/libraries/architecture)
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind observable data to UI elements.
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Create a UI that automatically responds to lifecycle events.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify domain layer data to views.
  - [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - Handle everything needed for in-app navigation.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - Construct app's SQLite database
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI related data holder, lifecycle aware.
- [Retrofit2](https://github.com/square/retrofit) - construct the REST APIs.
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin.
- [Hilt](https://dagger.dev/hilt/) - For [dependency injection](https://developer.android.com/training/dependency-injection/hilt-android).
- [FastAdapter](https://github.com/mikepenz/FastAdapter) - Create adapter for RecyclerViews.
- [Glide](https://github.com/bumptech/glide) - Loading images.
- [RoundCornerProgressBar](https://github.com/akexorcist/RoundCornerProgressBar) - Fully customizable with animations ProgressBar.


## Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
  
  ![architecute](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
  
  
## Api
Super Heroes using the [SuperHero API](https://superheroapi.com).
SuperHero API provides a RESTful API interface to highly detailed object buiflt from many of lines of data related to Super Heroes.

