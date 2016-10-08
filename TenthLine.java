# Read from the file file.txt and output the tenth line to stdout.

# Solution 1
# for i in `seq 1 10`;
# do
#     read line
# done < "file.txt"
# echo $line

# Solution 2
# awk 'NR==10' file.txt 

# Solution 3
# sed -n '10p' file.txt

# Solution 4
(cat file.txt; echo;echo;echo;echo;echo;echo;echo;echo;echo;echo;echo) | head -n 10 | tail -n 1