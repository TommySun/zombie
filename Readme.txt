1. Requirements

You will need jre 1.8 to run this.


2. To run this 
   in you console terminal run following
   
   java -jar <path>/zombie.jar

3. Design thoughts

   I imagine this challenge as a working prototype for a zombie programming game. Users   will plan moves for a zombie to infect as much as creatures on the board.
   I try to demonstrate my understanding of 3 design patterns: Abstract factory, chain of responsibility and build pattern.
   
   Abstract factory 
   This is used for decoupling dependency of logic from the caller. E.G. The GameEngineFactory will return an object implementing the GameEngine interface that is 
   responsible for the progress of the game. The would allow part of the solusion to be refactored without need of touching the caller.

   Builder pattern
   I use this to capsulat the complex logic of instantiating a class, which made the code more portable and readable

   Chain of Responsibility
   I use this pattern to break down the complex game play logic into smaller more manageable parts with a common object as the states of the chain. This allow more complicated logic 
   to be incoperated into the game play very easily. May be introduce the zombie hunter which have a random chance to kill your zombie.


4. Take away
    
   From my experience, the understanding of decoupling and design patterns is more important than knowing a piece of technology (though they both are very valuable), 
   because sooner or later, a software solution needs to be replateform with expansion of business. Either in scale or in complicity. An entangled dependency in code 
   could make such replatforming way too expensive for an organization to bear both in terms of manpower and time. 


