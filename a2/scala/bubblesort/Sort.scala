//Alexander Marshall 100487187
//Compile Errors: < 10
//Runtime Errors:

package bubblesort {
    class Bubble[T](input: Array[T])(implicit o: Ordering[T]) {
        def go() = {
            val s = new Sort(input)
            s.sort()
        }
    }

    class Sort[T <% Ordered[T]](input: Array[T])(implicit o: Ordering[T]) {
        def swap(a:Int, b:Int) = {
            var temp:T = input(a)
            input(a) = input(b)
            input(b) = temp
        }

        def printArr() = {
            if(input.length < 30)
                println(input.mkString(" "))
        }
        
        def sort () = {
            this.printArr()
            print("Sorting... ")
            var flag:Boolean = true

            while(flag) {
                flag = false
                for(i <- 1 to input.length-1) {
                    if(input(i-1) > input(i)) {
                        swap(i-1, i)
                        flag = true
                    }
                }
            }

            println("Done!")
            this.printArr()
        }
    }
}
