LISP ?= sbcl

build:
	$(LISP) --load factorial.asd \
		--eval '(ql:quickload :factorial)' \
		--eval '(asdf:make :factorial)' \
		--eval '(quit)'
