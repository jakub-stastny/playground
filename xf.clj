(defn mapping [f]
  (fn [f1]
    (fn [result input]
      (f1 result (f input)))))

(defn filtering [pred]
  (fn [f1]
    (fn [result input]
      (if (pred input) (f1 result input) result))))

; mapcatting and kin can produce more than one result per input by simply operating on result more than once
(defn mapcatting [f]
  (fn [f1]
    (fn [result input]
      (reduce f1 result (f input)))))

(println "mapping:")
(((mapping (fn [a] (prn :a a)))
  (fn [res in]
    (prn :result res :input in))) 1 "input")

(println "\nfiltering:")
(((filtering (fn [pred] (prn :pred pred)))
  (fn [res in]
    (prn :result res :input in))) 1 "input")
