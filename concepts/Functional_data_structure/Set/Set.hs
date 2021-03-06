module Set where

-- A signature for sets
data Set e s = Set {
  empty :: s e,
  insert :: e -> s e -> s e,
  search :: e -> s e -> Bool
}