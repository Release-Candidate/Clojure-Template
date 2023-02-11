;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     core_test.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns clojure-template.core-test2
  (:require
   [clojure-template.core :as my]
   [expectations.clojure.test :as t]))

(t/defexpect c-test
  (t/expect 10 (my/hugo 5)))

(t/defexpect d-test
  (t/expect 10 (my/hugo 6)))
