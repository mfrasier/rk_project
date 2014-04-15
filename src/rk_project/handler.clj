(ns rk_project.handler
  (:use rk_project.core, compojure.core, ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn handle-actor-name
  "handle response to actor name request"
  [name]
  (if (empty? name)
    {:status 400,
     :headers {"Content-Type" "application/json"}
     :body "{ \"status\" : \"400\", \"error\": \"Bad Request - name must be specified\" }"}

    {:status 200,
     :headers {"Content-Type" "application/json"}
     :body (:body (get-actor-data name))})
  )

(defroutes app-routes
  (GET "/" [] "Hello World")

  ; actor, query string style
  (GET "/actor" [name]
    (handle-actor-name name))

  ; actor, REST resource style
  (GET "/actor/:name" [name]
    (handle-actor-name name))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& m]
  (run-jetty (handler/site app-routes) {:port 8090}))
