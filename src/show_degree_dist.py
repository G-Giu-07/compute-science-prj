import numpy as np
import matplotlib.mlab as mlab
import matplotlib.pyplot as plt
from math import log

print("## reading file")

file = open("sample_output/sample_degree_distributions.txt", "r")

lines = file.read().splitlines()

file.close()

print("## file closed")


x = [float(a) for a in lines]
# print(sorted(x))

# x = x[: int(len(x)/1000)]

print("## data extracated")


# the histogram of the data
lenx = len(x)
n, bins, patches = plt.hist(x, lenx, facecolor='green')

print("## hist finished")

plt.xlabel('Probability')
plt.ylabel('degree distribution')
plt.title('Degree Distribution')

print("## Axis")

plt.axis([0, 1, 0, 940])
# plt.axis([0.1, 1, 0, 1])
plt.grid(True)

print("## saving the plot")
plt.savefig('output.png')

print("## plotting the data")
plt.show()