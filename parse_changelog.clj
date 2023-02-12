;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     parse_changelog.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns parse-changelog)

(set! *warn-on-reflection* true)

(defn- file->string
  "Returns the contents of the file at the given path `path` as a string."
  [path]
  (try
    (slurp path)
    (catch Exception e
      (println "Error reading file:" (.getMessage e))
      "")))

(defn- latest-changelog
  "Return the newest part of the changelog file at the given path."
  [path]
  (let [changelog-text (file->string path)]
    (if-some [[_ newest-change]
              (re-find #"(?x)(\#\#[\s\S]+)[\#]{0,2}+" changelog-text)]
      newest-change
      "")))

(latest-changelog "./CHANGELOG.md")
