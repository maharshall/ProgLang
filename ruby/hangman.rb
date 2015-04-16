#Alexander Marshall - 100487187
puts "Welcome to Hangman. 
How well do you know your UOIT Computer Science professors?"

wordBank = ["jeremy bradbury", "mark green", "randy fortier",
            "christopher collins", "dhavide aruliah", "ken pu",
            "jarek szlichta", "faisal qureshi"]

#get a random name
key = wordBank.sample
faults = 5

#string for storing guessed characters
guesses = "."

while true
    correct = 1 #initialize to 1 to include space
    print "\n\n\n"

    80.times {print "="}
    puts ""
    
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
    #get user input
    guess = gets.chomp

    if key.strip == guess.strip
        #check if guess equals key. strip removes spaces
        abort("Wow, you got it!\n#{key.upcase!} was the right answer!")
    elsif guesses.include? guess.chr
        #check if new guess matches a previous guess
        #use .chr to avoid the nil in guess
        puts "You already guessed that letter."
        next
    elsif key.include? guess.chr
        #check if key includes new guess
        puts "You got a letter!"
    else
        puts "Sorry! That's wrong!"
        faults -= 1
    end

    #update guessed characters
    guesses = guesses + "#{guess.chr}"
    
    if faults == 0
        #GAME OVER
        abort("\nYOU LOSE.\nThe answer was #{key.upcase!}")
    end
end
