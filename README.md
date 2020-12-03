[![GitHub issues](https://img.shields.io/github/issues/asarro99/AdventOfCode2020?style=flat-square)](https://github.com/asarro99/AdventOfCode2020/issues)
[![GitHub stars](https://img.shields.io/github/stars/asarro99/AdventOfCode2020?style=flat-square)](https://github.com/asarro99/AdventOfCode2020/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/asarro99/AdventOfCode2020?style=flat-square)](https://github.com/asarro99/AdventOfCode2020/network)
[![GitHub license](https://img.shields.io/github/license/asarro99/AdventOfCode2020?style=flat-square)](https://github.com/asarro99/AdventOfCode2020/blob/master/LICENSE)
![Codacy grade](https://img.shields.io/codacy/grade/c4b1577655854d16aa5177fb8600c116?logo=codacy&style=flat-square)
# AdventOfCode2020
This repository serves to hold all the solutions and utilities that I will use for [Advent Of Code 2020](https://adventofcode.com/2020).
The solutions are not the best or the most efficient. Proposals to improve them or other are always accepted.

### Running Days
The program runs day or every day test based on a control in the main class, that is, it runs on the current day until the advent period ends.
An example of day output is:
```text
Day 1:
Part 1: 234
Part 2: 567
Completed in 0.529s
```
### Data Manager and Input File
The program can automatically read the inputs of a specific day **using the Advent Of Code servers**.
To do this, you need to create a `session.txt` file containing the site's session cookie.
If the files are successfully obtained form the server, they are stored in a dedicated file in the `aoc_input` directory.
