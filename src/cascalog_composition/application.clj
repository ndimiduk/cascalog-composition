(ns cascalog-composition.application
  (:use [cascalog-composition business]
	[cascalog api]))

(defn- application-logic [a b c]
  "application-ns-internal function for converting business fields into application-relevant fields"
  (reverse [(count a) (count b) (count c)]))

(defn application-api-fn
  "public api for application"
  [source & [destination]]
  (let [source (business-atoms source)
	destination (if (nil? destination)
		      (stdout)
		      (lfs-textline destination))]
    (?<- destination [?result1 ?result2]
	 (source ?a1 _ ?a3 _ ?a5)
	 (application-logic ?a1 ?a3 ?a5 :> ?result1 _ ?result2)
	 (:distinct false))))
     
(defn -main [source & [destination]] (application-api-fn source destination))
