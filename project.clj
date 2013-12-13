(defproject hb-feed "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring/ring-servlet "1.2.0-RC1"]
                 [hb-scraper "0.1.0"]
                 [clojurewerkz/spyglass "1.0.0"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler hb-feed.handler/app}
  :min-lein-version "2.0.0"
  :aliases {"fetcher" ["run" "-m" "hb_feed.fetcher"]}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
