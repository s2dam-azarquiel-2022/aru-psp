(uiop:define-package :factorial/main
  (:documentation
   "Simple factorial algorithm")
  (:use :cl)
  (:export factorial
	   mainf))
(in-package :factorial/main)

(defun factorial (n)
  (if (= n 0)
    1
    (* n (factorial (1- n)))))

(defun mainf ()
  (format t
	  "~A~&"
	  (factorial (parse-integer (nth 1 sb-ext:*posix-argv*)))))
