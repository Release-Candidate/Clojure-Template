;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     parse_changelog.clj
;; Date:     11.Feb.2023
;;
;; ==============================================================================

(ns parse-changelog
  (:require [clojure.string :as str]))

(set! *warn-on-reflection* true)

(def default-in-file
  "The default path of the changelog file to read."
  "./Changelog.md")

(def default-out-file
  "The default path to the changelog file to generate."
  "./first_changelog.md")

(defn exit-with-message
  "Exit the program with exit code `err-code` and write message `msg` to stdout."
  [msg err-code]
  (println msg)
  (System/exit err-code))

(defn- file->string
  "Returns the contents of the file at the given path `path` as a string.
   This is a wrapper around `slurp` which exits the program if an exception has 
   been caught."
  [path]
  (try
    (let [in-path (if path path default-in-file)]
      (slurp in-path))
    (catch Exception e
      (exit-with-message (str "Error reading file: " (.getMessage e)) 1))))

(defn- latest-changelog
  "Return the newest part of the given changelog text string `changelog`."
  [changelog]
  (let [[_ newest-change]
        (str/split changelog #"(?m)^(?=\#\#\s)" 3)]
    (if newest-change
      newest-change
      "")))

(defn- version
  "Return the version of the given changelog text `changelog-part`.
   The version line must begin like this: '## Version VERSION', and `VERSION`
   shall be a combination of unicode numbers and punctuation characters (which 
   also includes parenthesis). If no valid version string has been found the 
   empty string `\"\"` is returned.

   Example: (version \"## Version 1.2.3-56_78\") => \"1.2.3-56_78\""
  [changelog-part]
  (let [[_ v]
        (re-find #"(?m)^\#\#\s+Version\s+([\p{N}\p{P}]+)" changelog-part)]
    (if v v "")))

(defn- check-changelog
  "Return the latest changelog part of the given changelog `text`.
   Return nil if the versions don't match or no valid last changelog part has 
   been found."
  [text check-vers]
  (let [current (latest-changelog text)
        v (version current)]
    (if (= v check-vers) current nil)))

(defn- write-changelog
  "Write the given string `text` to the file with path `out`.
   Exit the program on exceptions."
  [out text]
  (let [out-path (if out out default-out-file)]
    (try
      (spit out-path text)
      (catch Exception e
        (exit-with-message
         (str "Error writing to file " out-path " " (.getMessage e))
         2)))))

(defn -main
  "Main entry point of this program."
  [{v :version, in :in, out :out}]
  (if v
    (if-let [text (check-changelog (file->string in) v)]
      (write-changelog out text)
      (exit-with-message
       (str "Error parsing changelog file or changelog version doesn't match " v)
       3))
    (exit-with-message "Error: no version number to compare given!" 4)))
