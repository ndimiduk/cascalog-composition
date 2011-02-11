(ns cascalog-composition.business
  (:use [cascalog-composition parser]
	[cascalog api]))

(defn- raw-to-business-1
  "business-ns-internal function for converting raw fields into business-relevant fields"
  [a b]
  [(str a "-atom") (str a "-" b) (str b "-" a)])

(defn- raw-to-business-2
  "business-ns-internal function for converting raw fields into business-relevant fields"
  [a b]
  [(str a "-atom") (str b "-atom")])

(defn business-atoms [source]
  "business-ns query for reading the file format. Execute at the repl with:

   (?- (stdout) (business-atoms \"./data/input.txt\"))
  "
  (let [source (read-raw source)]
    (<- [?atom1 ?atom2 ?atom3 ?atom4 ?atom5]
	(source ?f1 ?f2)
	(raw-to-business-1 ?f1 ?f2 :> ?atom1 ?atom2 ?atom3)
	(raw-to-business-2 ?f2 ?atom3 :> ?atom4 ?atom5))))
