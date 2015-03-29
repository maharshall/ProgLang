//Alexander Marshall 100487187

import bubblesort.Bubble
import quicksort.Quick
import mergesort.Merge
import scala.math.Ordered._

object Main {
    def main(args: Array[String]) = {
        if(args.length < 3) {
            println("Usage: scala Main [Bubble/Quick/Merge] [Integer/Char/Float] [size]")
            System.exit(1)
        }

        val size:Int = args(2).toInt
        var ascend:Boolean = true

        args(1).toLowerCase() match {
            case "integer" => 
                var randInt = Array.fill(size)(util.Random.nextInt(100))
                args(0).toLowerCase() match {
                    case "bubble" =>
                        val b = new Bubble(randInt)
                        b.go()
                    case "quick" =>
                        val q = new Quick(randInt)
                        q.go()
                    case "merge" =>
                        val m = new Merge(randInt)
                        m.go()
                    case _ => println("Invalid option "+args(0))
                }
            case "char"  => 
                var randStr = Array.fill(size)(util.Random.nextPrintableChar())
                args(0).toLowerCase() match {
                    case "bubble" =>
                        val b = new Bubble(randStr)
                        b.go()
                    case "quick" =>
                        val q = new Quick(randStr)
                        q.go()
                    case "merge" =>
                        val m = new Merge(randStr)
                        m.go()
                    case _ => println("Invalid option "+args(0))
                }
            case "float"   => 
                var randFloat = Array.fill(size)(util.Random.nextFloat()*101.0f)
                args(0).toLowerCase() match {
                    case "bubble" =>
                        val b = new Bubble(randFloat)
                        b.go()
                    case "quick" =>
                        val q = new Quick(randFloat)
                        q.go()
                    case "merge" =>
                        val m = new Merge(randFloat)
                        m.go()
                    case _ => println("Invalid option "+args(0))
                }
            case _         => println("Invalid option "+args(1))
        }

    }
}
