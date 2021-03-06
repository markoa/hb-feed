(ns hb-feed.fetcher
  (:require [hb.scraper.manning :as manning]
            [hb.scraper.pragmatic :as pragmatic]
            [clojurewerkz.spyglass.client :as memcache]
            [hb-feed.memcache-common :refer :all]))

(defn five-days [] (* 60 60 24 5))

(defn fetch-books []
  (concat (map #(merge % {:publisher "manning"}) (manning/latest-books))
          (map #(merge % {:publisher "pragmatic"}) (pragmatic/latest-books))))

(defn write-books-to-cache [books]
  (let [conn (memcache-connection)
        serialized-books (prn-str books)
        res (memcache/set conn "books" (five-days) serialized-books)]
    (memcache/shutdown conn 3 java.util.concurrent.TimeUnit/SECONDS)))

(defn -main [& args]
  (let [books (fetch-books)]
    (printf "got %s books\n" (count books))
    (write-books-to-cache books)))
