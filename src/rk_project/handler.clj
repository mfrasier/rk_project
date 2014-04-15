(ns rk_project.handler
  (:use compojure.core, ring.adapter.jetty)
  (:require [rk_project.core]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")

  ; query string style
  (GET "/actor" [name]
       ; (if (or (nil? actor-name) (= (.length name) 0))
       ;  "{ \"status\" : \"400\", \"error\": \"Bad Request - no name specified\" }"
       (rk_project.core/get-actor-data name))

  ; REST resource style
  (GET "/actor/:name" [name]
      (rk_project.core/get-actor-data name))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& m]
  (run-jetty (handler/site app-routes) {:port 8080}))
