(ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]

            ;;[cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]
            [liberator.core :refer :all]))

;; --

;;(defroutes app-routes
;;  (GET "/" [] "Hello World")
;;  (GET "/cheshire-cat" [] {:status 200
;;                           :headers {"Content-Type" "application/json; charset=utf-8"}
;;                           :body (json/generate-string {:name "Cheshire Cat"
;;                                                        :status "grinning"})})
;;  (route/not-found "Not Found"))

;; (def app
;;  (wrap-defaults app-routes site-defaults))

;; --

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/cheshire-cat" []
       (rr/response {:name "Cheshire Cat"
                     :status "grinning"}))
  (ANY "/cat" []
    (resource :available-media-types ["text/plain"
                                      "text/html"
                                      "application/json"]
             :handle-ok 
              #(let [media-type (get-in % [:representation :media-type])]
                 (case media-type
                   "text/plain" "Cat"
                   "text/html" "<html><h2>Cat</h2></html>"
                   "application/json" {:cat true}))
              
              :handle-not-acceptable "No Cats Here!"))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))
