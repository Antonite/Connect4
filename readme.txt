4003-243 Project 01: README
===============================
(please use the RETURN key to make multiple lines; don't assume autowrap.)

0. Author Information
---------------------

CS Username: 	axp9304		Name:  		Anton Pashyk

-------------------
1. Problem Analysis
-------------------

Summarize the analysis work you did. 
What new information did it reveal?  How did this help you?
How much time did you spend on problem analysis?

	Throughout the analysis stage, I mainly considered the objects required to make the project work.
	It took me about 20 minutes to have a rough idea of what objects I will implement and how they will connect.

---------
2. Design
---------

Explain the design you developed to use and why. 
What are the major components? What connects to what?
How much time did you spend on design?

	The design phase took me a few hours. The main class is, of course, Connect4, which connects everything together.
	Most of the data about the board and operations on the board was implemented inside the board class, which is a
	simple 2D array that is based on the given number of rows and columns. And in order to accommodate for different
	intelligence of players I implemented the abstract mind class, which builds into the multiple player types
	consisting of: random, human, bad, and good. All of these implement the interface player, which shares the
	essential getMove function. During runtime, Connect4 calls upon the players to make a move, who call upon the
	board class to evaluate anything based on each player. 

-----------------------------
3. Implementation and Testing
-----------------------------

Describe your implementation efforts here; this is the coding and testing.

What did you put into code first?
How did you test it?
How well does the solution work? 
Does it completely solve the problem?
Is anything missing?
How could you do it differently?
How could you improve it?
What design changes are needed for the next iteration?

How much total time would you estimate you worked on the project? 
If you had to do this again, what would you do differently?

	The first thing I implemented was the framework of the classes. From there I slowly filled in board class and 
	Connect4 class. Lastly I coded the player classes, updating board and connect4 classes when needed.
	Testing was easy because the toString method was one of the first to be implemented. I had a clear idea of what
	was going on and could freely construct my own versions of the board with a neat appearance. As far as I know, I
	have completely solved the problem at hand. I have passed all the tests on try and fixed any bugs I could find 
	through endless testing. However, I could probably eliminate some messy code in a few places. I guess that would
	be the only improvement I can see. Otherwise, I think my current design solves the problem just fine. The only
	thing I wish to change is to start the project a few days earlier. I honestly did not think it would take me as
	much time as it did. I started 2 days before it was due, and ended up burning through 3, thus being late.

----------------------
4. Development Process
----------------------

Describe your development process here; this is the overall process.

How much problem analysis did you do before your initial coding effort?
How much design work and thought did you do before your initial coding effort?
How many times did you have to go back to assess the problem?

What did you learn about software development?

	As I have said before, it only took me about 20 minutes to establish the framework for my classes. I did not
	change anything major after that point, besides adding a few more variables to methods here and there. What I
	learned, thankfully through a pleasant experience, is the importance of timely testing. Having an easy and fast
	way of testing methods while the rest of the methods are still not written helps immensely. 