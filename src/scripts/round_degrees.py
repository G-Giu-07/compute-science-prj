
file = open("degree_distributions.txt", "r")

lines = file.read().splitlines()

file.close()

values = [round(float(a), 1) for a in lines]

degrees = {}

for i in values:
  if i not in degrees:
    degrees[i] = 0
  else:
    degrees[i] += 1

print(degrees)
