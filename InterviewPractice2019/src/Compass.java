/*
We are building a word processor and we would like to implement a "word-wrap" functionality.
Given a maximum number of characters in a line followed by a list of words, return a collection of strings where each string element represents a line that contains as many words as possible, with the words in each line being concatenated with a single '-' (representing a space, but easier to see for testing). The length of each string must not exceed the maximum character length per line.
Your function should take in the maximum characters per line and return a data structure representing all lines in the indicated max length.
Note: built-in functions like Python textwrap module should not be used as solutions to this problem.

Examples:

words1 = [ "The", "day", "began", "as", "still", "as", "the",
          "night", "abruptly", "lighted", "with", "brilliant",
          "flame" ]

wrapLines(words1, 13) ... "wrap words1 to line length 13" =>

  [ "The-day-began",
    "as-still-as",
    "the-night",
    "abruptly",
    "lighted-with",
    "brilliant",
    "flame" ]

wrapLines(words1, 20) ... "wrap words1 to line length 20" =>

  [ "The-day-began-as",
    "still-as-the-night",
    "abruptly-lighted",
    "with-brilliant-flame" ]
    
words2 = [ "Hello"]

wrapLines(words2, 5) ... "wrap words2 to line length 5" =>
  [ "Hello" ]

n = number of words / total characters

*/

public class Compass {

}
