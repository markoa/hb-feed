(ns hb-feed.handler
  (:use compojure.core
        hb-feed.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET "/" [] {:body {:hello "world"}})
  (GET "/books.json" [] {:body (books-feed)})
  (route/resources "/")
  (route/not-found {:body {:error "not found"}}))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-response)))
