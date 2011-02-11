(ns cascalog-composition.parser
  (:use cascalog.api)
  (:require [cascalog [ops :as c]]))

(defn- filter-empty-lines
  "parser-ns-internal function related to parsing the file format."
  [line]
  (not (re-matches #"[^\S]+" line)))

(defn- filter-#-lines
  "parser-ns-internal function related to parsing the file format."
  [line]
  (not (re-matches #"^#.*" line)))

(defn read-raw
  "parser-ns query for reading the file format. Execute at the repl with:

   (?- (stdout) (read-raw \"./data/input.txt\"))
  "
  [source]
  (let [source (hfs-textline source)]
    (<- [?f1 ?f2]
	(source ?line)
	(filter-#-lines ?line)
	(filter-empty-lines ?line)
	(c/re-parse [#"[^\t]+"] ?line :> ?f1 ?f2))))

