(defproject rk_project "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [clj-http "0.1.3"]
                 [ring/ring-jetty-adapter "1.2.2"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler rk_project.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
