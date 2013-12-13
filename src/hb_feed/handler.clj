(ns hb-feed.handler
  (:use compojure.core
        hb-feed.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/books.json" [] (books-feed))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
