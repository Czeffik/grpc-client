# GRPC client sample app
Spring boot application implemented as GRPC client for [ActiveMQ - GRPC service](https://github.com/Czeffik/active-mq)
If you want make full flow test:
- start [ActiveMQ - GRPC service](https://github.com/Czeffik/active-mq)
- start **this** application
- send requests (you can open multiple streams), for example: `curl localhost:8080/stream/information/1` - it will start GRPC stream between this app and [ActiveMQ - GRPC service](https://github.com/Czeffik/active-mq)
- send message to *ActiveMQ* topic - more information in [README FILE](https://github.com/Czeffik/active-mq/blob/master/readme.md)
- observe logs of this application - app should start logging incoming messages via **GRPC** stream

### Build
```shell script
./gradlew clean build
```
build is **required** for development because generate *JAVA* classes from `*.proto` files.

### How to

* start application
* send HTTP request and watch logs


**Start stream with:**

`curl localhost:8080/stream/information/1`

**Get single information with:**

`curl localhost:8080/information/1`




