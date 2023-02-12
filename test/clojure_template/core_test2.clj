;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     core_test2.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns clojure-template.core-test2
  (:require [clojure-template.core :as my]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [expectations.clojure.test :as t]))

(defn- shrunk->message
  "Return an error message from the given shrunk map `m`."
  [m]
  (let [{seed :seed
         num-tests :num-tests
         {:keys [smallest]} :shrunk} m]
    (str "Seed: " seed "\nShrunk value: "
         smallest "\nNumber of tests: " num-tests
         "\n" (dissoc m :property))))


(defmacro tc->expect
  "Generate a function to be passed as `reporter-fn` to `quick-check`."
  [f-name msg]
  `(fn [m#]
     (t/defexpect
       ~f-name
       (t/expect
        {:result true}
        {:result (:result m#)}
        (str ~msg "\n" (shrunk->message m#))))))

(comment
  (macroexpand '(tc->expect bla "ASDSADA"))
  :rcf)

(tc/quick-check
 10000
 (prop/for-all [x gen/small-integer]
               (= (+ 6 (abs x)) (my/foo x)))
 {:reporter-fn (tc->expect
                c-test
                "This should fail 3.\n(+ 6 (abs x)) (my/foo x)")})

(tc/quick-check
 10000
 (prop/for-all [x gen/small-integer]
               (= (+ 6 x) (my/foo x)))
 {:reporter-fn (tc->expect d-test "This should not fail 4.")})
