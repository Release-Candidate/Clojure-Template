;; SPDX-License-Identifier: MIT
;; Copyright (C) 2023 Roland Csaszar
;;
;; Project:  Clojure-Template
;; File:     build.clj
;; Date:     12.Feb.2023
;;
;; ==============================================================================
(ns build
  (:require
   [clojure.tools.build.api :as b]))

(def prog "The programs namespace." 'clojure-template)
(def version
  "Get the current version from the biggest Git tag that matches `v*`."
  (format "%s" (first (b/git-process {:dir "."
                                      :git-command "git"
                                      :git-args ["tag"
                                                 "--list"
                                                 "--sort=-version:refname"
                                                 "v*"]}))))
(def class-dir "Doc." "target/classes")

(def basis
  "Read deps.edn for dependencies."
  (b/create-basis {:project "deps.edn"}))

(def uber-file
  "The filename of the überjar."
  (format "target/%s-%s-standalone.jar" (name prog) version))

(comment
  (name prog)
  :rcf)

(defn clean
  "Delete everything the directory `target`."
  [_]
  (b/delete {:path "target"}))

(defn uber
  "Generate an überjar."
  [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis basis
           :main 'clojure-template.core}))
