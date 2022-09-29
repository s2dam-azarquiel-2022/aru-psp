(asdf:defsystem :factorial
  :description "Programa en LISP para calcular el factorial de un numero."
  :author "aruZeta"
  :class :package-inferred-system
  :depends-on (:factorial/main)
  :build-operation "program-op"
  :build-pathname "factorial"
  :entry-point "factorial/main:mainf")
