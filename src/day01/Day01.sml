fun part1(nil) = 0
  | part1(x :: nil) = 0
  | part1(x :: y :: xlist) = if x < y then 1 + part1(y::xlist) else 0 + part1(y::xlist);