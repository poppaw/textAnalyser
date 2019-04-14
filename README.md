# Text Analyser

My task was to implement a tool for lexical analysis of text data.

An example of the programs usage and output with descriptions is shown by file [expected view](text_analyser_view.png)

Take a look at the UML diagram [UML diagram](UML.png).

NOTES:

       - Private methods are not shown on the diagram. You are free to implement any necessary/helpful private methods in any class.
       - Use the Iterator interface from java.util. You don’t have to create your own.
       - The input files will only consist of alphabetic characters and white spaces.
       - The input file will consist both upper and lower case characters. You should use only one case to ensure that the results of the analysis will be consistent.

Application (here as StartAnalyser) starts by invoking in command line Application class with main method. It should allow the user to pass to text files for analysis as CLI arguments. For example: 
> java Application text1.txt text2.txt 
