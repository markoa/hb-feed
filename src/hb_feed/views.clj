(ns hb-feed.views
  (:require [clojure.data.json :as json]
            [clojurewerkz.spyglass.client :as memcache]
            [hb-feed.memcache-common :refer :all]))

(defn books-feed []
  (let [conn (memcache/text-connection memcache-address)
        books (memcache/get conn "books")]
    (json/write-str books)))
