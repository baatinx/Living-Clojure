(ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]

            ;;[cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]))

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
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))
