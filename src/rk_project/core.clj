(ns rk_project.core
  (:require [clj-http.client :as client]))

; example query url: http://www.imdb.com/xml/find?json=1&nr=1&nm=on&q=John+Wayne
(def imdb-url "http://www.imdb.com/xml/find")

(defn get-actor-data
  "get actor data from imdb call"
  [actor-name]
  (println (str "DEBUG: getting actor '" actor-name "'"))
  (let [response
        (client/get imdb-url
            {:accept :json
             :query-params {"json" "1"
                            "nr" "1"
                            "nm" "on"
                            "q" actor-name}})]
    response))
