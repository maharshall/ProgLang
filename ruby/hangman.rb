puts "Welcome to Hangman. 
How well do you know your UOIT Computer Science professors?"

wordBank = ["jeremy bradbury", "mark green", "randy fortier",
            "christopher collins", "dhavide aruliah", "ken pu",
            "jarek szlichta", "faisal qureshi"]

key = wordBank.sample
faults = 5
guesses = "."

while true
    correct = 1
    print "\n\n\n"

    80.times {print "="}
    
    key.split("").each do |i|
        if guesses.include? i
            print " #{i.upcase!} "
            correct += 1
        elsif i == " "
            print "\t"
        else
            print " _ "
        end
    end
    
    puts ""
    80.times {print "="}
    
    if correct == key.length
        abort("\nYou Win!")
    end
    
    puts "\nFaults remaining: #{faults}"
    print "Guess a letter (or the whole thing!): "
    guess = gets.chomp

    if key.strip == guess.strip
        abort("Wow, you got it!\n#{key.upcase!} was the right answer!")
    elsif guesses.include? guess.chr
        puts "You already guessed that letter."
        next
    elsif key.include? guess.chr
        puts "You got a letter!"
    else
        puts "Sorry! That's wrong!"
        faults -= 1
    end

    guesses = guesses + "#{guess.chr}"
    
    if faults == 0
        abort("\nYOU LOSE.\nThe answer was #{key.upcase!}")
    end
end
