(ns rk_project.test.handler
  (:use clojure.test
        ring.mock.request  
        rk_project.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "actor-query-with-empty-name"
    (let [response (app (request :get "/actor?name="))]
      (is (= (:status response) 400))))

  (testing "actor-query-with-name"
    (let [response (app (request :get "/actor?name=John+Wayne"))]
      (is (= (:status response) 200))))

  (testing "actor-resource-with-name"
    (let [response (app (request :get "/actor/John+Wayne"))]
      (is (= (:status response) 200))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
