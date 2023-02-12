;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     core.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns clojure-template.core
  (:require [clojure.spec.alpha :as s])
  (:gen-class))

(defn foo
  "Return `x + 6`."
  [x]
  {:pre [(s/valid? number? x)]
   :post [(s/valid? number? %)]}
  (+ x 6))

(defn -main
  "The program's main entry point."
  [& _]
  (println (foo 9)))

(comment

  (foo 5.0)
  #_(foo "bar")

  :rcf)
