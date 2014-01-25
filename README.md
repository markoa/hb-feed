# hb-feed

JSON API based on [hb-scraper](https://github.com/markoa/hb-scraper).

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Overview

There's a task `lein fetcher` which saves a list of books in Memcache. The web server, implemented with [Compojure](https://github.com/weavejester/compojure), responds with JSON based on the data in cache:

    GET /books.json

## Running

To start a web server for the application, run:

    lein ring server

The application is running on Heroku. Relevant configuration is in `Procfile` and `system.properties.`

## License

Copyright © 2014 Marko Anastasov

Distributed under the MIT License.
