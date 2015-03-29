//Alexander Marshall 100487187
//Compile Errors: <10
//Runtime Errors:

package mergesort {
    class Merge[T <% Ordered[T]](input: Array[T]) {
        def go() = {
            val s = new Sort(input)
            s.sort()
        }
    }

    class Sort[T <% Ordered[T]](input: Array[T]) {
        var holder:Array[T] = Array.empty[T]
        
        def printArr() = {
            println(input.mkString(" "))
        }
        
        def sort() = {
            this.printArr()
            print("Sorting... ")
            mergesort(0, input.length-1)
            println("Done!")
            this.printArr()
        }

        def mergesort(low:Int, high:Int) : Unit = {
            if(low < high) {
                val middle:Int = low + (high-low)/2
                mergesort(low, middle)
                mergesort(middle+1, high)
                merge(low, middle, high)
            }
        }

        def merge(low:Int, middle:Int, high:Int) = {
            for(x <- low to high) {
                holder(x) = input(x)
            }
            var i:Int = low
            var j:Int = middle+1
            var k:Int = low

            while(i <= middle && j <= high) {
                if(holder(i) <= holder(j)) {
                    input(k) = holder(i)
                    i = i+1
                } else {
                    input(k) = holder(j)
                    j = j+1
                }
                k = k+1
            }

            while(i <= middle) {
                input(k) = holder(i)
                i = i+1
                k = k+1
            }
        }
    }
}
