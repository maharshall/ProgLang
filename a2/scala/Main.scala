//Alexander Marshall 100487187

import bubblesort.Bubble
import quicksort.Quick
import mergesort.Merge

object Main {
    def main(args: Array[String]) = {
        if(args.length < 4) {
            println("Usage: scala Main [Bubble/Quick/Merge] [Integer/String/Float] [ascend/descend] [size]")
            System.exit(1)
        }

        val size:Int = args(3).toInt
        var ascend:Boolean = true

        args(2).toLowerCase() match {
            case "descend" => ascend = false
            case "ascend"  => ascend = true
            case _         => println("Invalid option "+args(2))
        }

        var randArr = new Array[Int](size)

        args(1).toLowerCase() match {
            case "integer" => randArr = Array.fill(size)(util.Random.nextInt(100))
        //    case "string"  => randArr = Array.fill(size)(util.Random.alphanumeric)
        //    case "float"   => randArr = Array.fill(size)(util.Random.nextFloat()*101.0f)
            case _         => println("Invalid option "+args(1))
        }

        args(0).toLowerCase() match {
            case "bubble" =>
                val b = new Bubble(randArr)
                b.go()
            case "quick" =>
                val q = new Quick(randArr)
                q.go()
            case "merge" =>
                val m = new Merge(randArr)
                m.go()
            case _ => println("Invalid option "+args(0))
        }
    }
}
