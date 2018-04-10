# [Astronomy Picture of the Day](https://apod.nasa.gov/apod/astropix.html)

## Overview
This application utilizes NASA Open API to display astronomy picture of the day including other data
returned by the API. It's been designed to present the most convenient way to work with mocked data
during the development process to avoid hitting real API service. It uses only **`DEMO_KEY`**, which 
has some [limitations](https://api.nasa.gov/api.html#demo_key-rate-limits) 
in terms of number of requests per hour and day. 

## Characteristic  

 This app is build upon the MVVM architecture. It provides different flavors to distinguish between
 the real app that makes network calls to the API and its mocked version, which does not hit the server.
 
 Libraries used:
 * [Dagger](https://google.github.io/dagger/)
 * [RxJava](https://github.com/ReactiveX/RxJava) & [RxAndroid](https://github.com/ReactiveX/RxAndroid)
 * [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html)
 * [Retrofit](http://square.github.io/retrofit/)
 * [OkHttp](http://square.github.io/okhttp/)
 * [Moshi](https://github.com/square/moshi)
 * [OkHttp](http://square.github.io/okhttp/)
 * [Picasso](http://square.github.io/picasso/)



## Usage

There are 2 flavors of the app:
- `prod` - it uses real API endpoint with `DEMO_KEY` 
- `dev` - it uses mocked data without the real network call
