(ns clojure-template.runner
  (:require
   [eftest.report :as efr]
   [eftest.report.junit :as efju]
   [eftest.runner :as ef]))

(set! *warn-on-reflection* true)

(defn -main
  "Main entry point.
   Run the eftest test runner and return the number of failed tests."
  [{in-ci? :in-ci?}]
  (let  [{num-fail :fail  num-error :error}
         (if in-ci?
           (ef/run-tests (ef/find-tests "./") {:report (efr/report-to-file efju/report "test.xml")})
           (ef/run-tests (ef/find-tests "./")))]
    (System/exit (+ num-error num-fail))))
