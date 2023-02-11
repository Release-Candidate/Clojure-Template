(ns clojure-template.runner
  (:require
   [eftest.report :as efr]
   [eftest.report.junit :as efju]
   [eftest.runner :as ef]))

(set! *warn-on-reflection* true)

(defn -main
  "Main entry point.
   Run the eftest test runner and return the number of failed tests."
  [_]
  (let  [{num-fail :fail  num-error :error}
         (ef/run-tests (ef/find-tests "./") {:report (efr/report-to-file efju/report "test.xml")})]
    (System/exit (+ num-error num-fail))))
