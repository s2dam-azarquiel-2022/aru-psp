import System.Environment (getArgs)

factorial :: Integer -> Integer
factorial 0 = 1
factorial n = (*) n . factorial $ n - 1

main :: IO ()
main = do
  args <- getArgs
  let result = factorial $ read $ head args
  print result
