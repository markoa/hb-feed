(ns hb-feed.test.handler
  (:use clojure.test
        ring.mock.request  
        hb-feed.handler))

(deftest test-app
  (testing "root path"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json; charset=utf-8"}))))

  (testing "/books.json"
    (with-redefs [hb-feed.views/books-feed
                  (fn [] '({:title "joy of clojure"}
                           {:title "programming clojure"}))]
      (let [response (app (request :get "/books.json"))]
        (is (= (:status response) 200))
        (is (= (:headers response) {"Content-Type" "application/json; charset=utf-8"})))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
