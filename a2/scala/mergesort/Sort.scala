//Alexander Marshall 100487187
//Compile Errors:
//Runtime Errors:

package mergesort {
    class Merge[T <% Ordered[T]](input: Array[T]) {
        def go() = {
            val s = new Sort(input)
            s.sort()
        }
    }

    class Sort[T <% Ordered[T]](input: Array[T]) {
        def swap(a:Int, b:Int) = {
            var temp:T = input(a)
            input(a) = input(b)
            input(b) = temp
        }

        def printArr() = {
            println(input.deep.mkString("\n"))
        }
        
        def sort () = {
            this.printArr()
            print("Sorting... ")
            //Do the sort
            println("Done!")
            this.printArr()
        }
    }
}
