import
  std/[os, parseopt],
  pkg/[bigints]

func factorial(n: BigInt): BigInt =
  if n == 0: 1.initBigInt
  else: n * factorial(n - 1.initBigInt)

var
  params = commandLineParams().initOptParser
  number: BigInt

for kind, key, val in params.getopt():
  case kind
  of cmdEnd, cmdLongOption, cmdShortOption: discard
  of cmdArgument: number = key.initBigInt

echo factorial number
