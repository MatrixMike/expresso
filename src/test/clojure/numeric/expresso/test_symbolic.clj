(ns numeric.expresso.test-symbolic
  (:refer-clojure :exclude [])
  (:use [clojure.core.logic.protocols]
        [numeric.expresso.symbolic]
        [numeric.expresso.matcher]
        [numeric.expresso.protocols]
        clojure.test)
  (:require [clojure.core.logic.fd :as fd]
            [clojure.walk :as walk]
            [clojure.core.matrix.operators :as matop]
            [numeric.expresso.utils :as utils]
            [clojure.core.matrix :as mat]
            [numeric.expresso.construct :as c]))

(def test2 (mat/matrix [[0 1 2 3 4 5]
                        [0 1 2 3 4 5]
                        [5 4 3 2 1 0]
                        [0 1 2 3 4 5]]))

(def test3 (mat/matrix [[1 2]
                        [3 4]
                        [5 6]]))

(def test4 (mat/matrix [[2 1 -1 8]
                        [-3 -1 2 -11]
                        [-2 1 2 -3]]))

(deftest test-gaus-solve
  (is (mat/e== [1/2 -1 3/4 2] (gaus-solve testmatrix)))
  (is (= '() (gaus-solve test3)))
  (is (= '(_0) (gaus-solve test2)))
  (is (mat/e== [2 3 -1] (gaus-solve test4))))