def fib(n)
  if n < 2
    1
  else
    fib(n - 1) + fib(n - 2)
  end
end

puts fib(15)

#ruby --inspect sample.rb
#the open Chrome and point to the URL displayed by the above run