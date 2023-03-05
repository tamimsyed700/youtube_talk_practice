import java.util.*;

public class Sample {
  public static void main(String[] args) {
  }
}

/*
Folks using JavaScript learned the hard lessons of callbacks.

They moved on to using Promises.

A promise is an "object" that may complete in the future.

A promise is in one of three states:
-a pending state (is temporary, but may be there for a long time or forever)
-resolved state (terminal)
-rejected state (terminal)

Railway track pattern


=======✔=========✔=============================✔=====
 d -> f -> P -> f -> P -> f -> P -> f -> P -> f ->...
===========================e=========e===============

If a function resolves a promise, it goes to the next then on the top
If a function rejects a promise, it goes to the next catch on the bottom

  Where are you    What happens    Where you end up
    then(top)        success           next then(top)
    then(top)        failure           next catch(bottom)
    catch(bottom)    success           next then(top)
    catch(bottom)    failure           next catch(bottom)

  then1 ->        then2 ->       then3 -> then4
          catch1           catch2               catch3


1. then1, then2, then3, then4
2. then1, catch1, then2, then3, then4
3. then1, catch1, catch2, then3, then4
4. then1, catch1, catch2, catch3
5. then1, catch1, then2, catch2, then3, catch 3
...

*/

