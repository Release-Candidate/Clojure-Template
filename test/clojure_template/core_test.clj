;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     core_test.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns clojure-template.core-test
  (:require
   [clojure-template.core :as my]
   [expectations.clojure.test :as t]))


(t/defexpect a-test
  (t/expect 10 (clojure-template.core/hugo 5) "This should fail 1"))

(t/defexpect b-test
  (t/expect 10 (my/hugo 6) "This should fail 2"))
