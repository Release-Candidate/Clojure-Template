;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     runner.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns clojure-template.runner
  (:require
   [eftest.report :as efr]
   [eftest.report.junit :as efju]
   [eftest.runner :as ef]))

(set! *warn-on-reflection* true)

(defn -main
  "Main entry point.
   Run the eftest test runner and return the number of failed tests.
   If the command line argument `in-ci?` is `true`, write the output to the file
   'test.xml' in JUnit format."
  [{in-ci? :in-ci?}]
  (let  [{num-fail :fail  num-error :error}
         (if in-ci?
           (ef/run-tests (ef/find-tests "./test") {:report (efr/report-to-file efju/report "test.xml")})
           (ef/run-tests (ef/find-tests "./test")))]
    (System/exit (+ num-error num-fail))))

(comment
  ;; Run the tests. WARNING: exits from the REPL, it has to be jacked in again.
  (-main {:in-ci false})
  :rcf)
