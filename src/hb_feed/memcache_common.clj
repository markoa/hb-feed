(ns hb-feed.memcache-common
  (:require [clojurewerkz.spyglass.client :as memcache]))

(defn using-localhost? []
  (clojure.string/blank? (System/getenv "MEMCACHIER_USERNAME")))

(defn memcache-connection []
  (if (using-localhost?)
    (memcache/text-connection "127.0.0.1:11211")
    (memcache/bin-connection (System/getenv "MEMCACHIER_SERVERS") (System/getenv "MEMCACHIER_USERNAME") (System/getenv "MEMCACHIER_PASSWORD") :plain)))
