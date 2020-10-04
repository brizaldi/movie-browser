# Movie Browser 
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)

Another movie app using data from [The Movie DB](https://www.themoviedb.org) based on Android & Kotlin.<br>

## How to build on your environment
Add your API key in local.properties file.
```xml
tmdb_api_key=YOUR_API_KEY
```

## Specs & Open-source libraries
- Architecture Components (Lifecycle, LiveData, ViewModel, Room Persistence)
- DataBinding
- The Movie DB API
- [Dagger2](https://github.com/google/dagger) for dependency injection
- [Retrofit2 & Gson](https://github.com/square/retrofit) for constructing the REST API
- [OkHttp3](https://github.com/square/okhttp) for implementing interceptor, logging and mocking web server
- [Glide](https://github.com/bumptech/glide) for loading images
- [BaseRecyclerViewAdapter](https://github.com/skydoves/BaseRecyclerViewAdapter) for implementing adapters and viewHolders
- [WhatIf](https://github.com/skydoves/whatif) - checking nullable object and empty collections more fluently
- [Timber](https://github.com/JakeWharton/timber) for logging
- [Stetho](https://github.com/facebook/stetho) for debugging persistence data & network packets
- Custom Views [ExpandableTextView](https://github.com/Manabu-GT/ExpandableTextView)
