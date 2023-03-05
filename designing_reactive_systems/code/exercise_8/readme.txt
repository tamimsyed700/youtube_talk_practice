Visit http://elm-lang.org/try and type in the example.

import Signal (..)
import Mouse
import Window
import Graphics.Collage (..)
import Color (..)

ball = filled blue (circle 30)

drawBall (width, height) position =
  let x = (toFloat (fst position)) - (toFloat width) / 2
      y = (toFloat height) / 2 - (toFloat (snd position))
  in
    collage width height [ball |> move(x, y)]

main = 
  map2 drawBall Window.dimensions Mouse.position
  
