//Alexander Marshall 100487187
//Compile Errors: <5
//Runtime Errors:

package quicksort {
    class Quick[T](input: Array[T])(implicit o: Ordering[T]) {
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
            quicksort(0, input.length-1)
            println("Done!")
            this.printArr()
        }

        def quicksort(start:Int, end:Int) {
            if(start < end) {
                val pivot:T = input(end)
                var i:Int = start
                var j:Int = end

                while(i != j) {
                    if(input(i) < pivot) {
                        i = i+1
                    } else {
                        input(j) = input(i)
                        input(i) = input(j-1)
                        j = j-1
                    }
                }

                input(j) = pivot
                quicksort(start, j-1)
                quicksort(j+1, end)
            }
        }
    }
}
