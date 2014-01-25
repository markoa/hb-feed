(ns hb-feed.test.handler
  (:use clojure.test
        ring.mock.request  
        hb-feed.handler))

(deftest test-app
  (testing "root path"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json; charset=utf-8"}))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
