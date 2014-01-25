(ns hb-feed.views
  (:require [clojure.data.json :as json]
            [clojurewerkz.spyglass.client :as memcache]
            [hb-feed.memcache-common :refer :all]))

(defn books-feed []
  (let [conn (memcache-connection)
        books-str (memcache/get conn "books")]
    (read-string books-str)))
