Written by Derrick Futschik - s3236434@student.rmit.edu.au

LISCENSE: you can use for any reason, can’t sell this but!

NOTE: Only tested with 32bit jvm
NOTE: Does uses platform specific binaries however I do believe
	  they have included them all for ios, linux as well as windows.


QUICKSTART: Simply run release/rhinova.jar and open the rhinoExample.txt file. Then got to Configure-Configure model and then
	    Click the green button on the bottom, and play the movie, look at the graphs, ect.


SETTING UP THE PROJECT - From eclipse simply go File->Import->Git->Clone
						and then enter https://github.com/derrick3192/Rhinova.git
						And then go get a coffee because it takes some time
						 
BUILDING - Simply run RhinovaLancher from eclipse
				OR
		   If you want to make the jar yourself run the build.xml file with ant, and the
		   jar will magically appear in the release folder.
		   
		   If you want to generate the javadoc and what not simply edit the build.xml top
		   from default="run" to default="all"

ISSUES: 

CONFIGURE: Allot of the options are not actually implemented. I recommend only configuring the
years.

SOLVER: If you want to solve the model again using different
settings you have to restart the program.

SOLVER: The reliability of the solver is not well tested. While when it is successful it has worked,
however I cannot guarantee  that if it hasn't work that there is not a problem in my code.

SOLVER: The solver doesn’t give feedback for any errors, (other than what is printed onto the console).

LINK: The edit data table for the Links does not show correctly. I have found working with JTables in
Java to be an excellent waste of my time so I am no longer trying to fix this issue.

RESERVE: The edit data table for the Reserve will not work at all, only displays the data.
as I could not get this feature working for the Links I didn’t bother to do so for the Reserves.
