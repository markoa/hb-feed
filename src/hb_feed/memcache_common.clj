(ns hb-feed.memcache-common)

(defn memcache-address []
  (if (clojure.string/blank? (System/getenv "MEMCACHIER_USERNAME"))
    ["127.0.0.1:11211"]
    [(System/getenv "MEMCACHIER_SERVERS")
     (System/getenv "MEMCACHIER_USERNAME")
     (System/getenv "MEMCACHIER_PASSWORD")]))
