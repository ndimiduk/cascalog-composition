(defproject cascalog_composition "1.0.0-SNAPSHOT"
  :description "FIXME: write"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		 [cascalog "1.7.0-SNAPSHOT"]]
  :dev-dependencies [[org.apache.hadoop/hadoop-core "0.20.2-dev"]
		     [swank-clojure "1.2.1"]
		     [lein-run "1.0.1-SNAPSHOT"]]
  :main cascalog-composition.application)
