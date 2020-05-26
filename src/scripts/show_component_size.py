import matplotlib.pyplot as plt

print("## reading file")

# file = open("../sample_output/component_size.txt", "r")
file = open("../component_size_entire_DB.txt", "r")

lines = file.read().splitlines()

file.close()

print("## file closed")

x = [float(a) for a in lines]
x = sorted(x)

component_size = {}

for i in x:
  if i in component_size:
    component_size[i] += 1
  else:
    component_size[i] = 1

newx = [float(component_size[a]) for a in component_size]
plt.bar([a for a in range(len(component_size))], newx)
plt.show()
