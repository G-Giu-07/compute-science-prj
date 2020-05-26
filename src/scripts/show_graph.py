import pylab
import networkx as nx
import matplotlib.pyplot as plt

# Config
file_name = "../sample_output/IDs.txt"

file = open(file_name, "r").read()
arr = file.split("\n")
arr.pop()

G = nx.Graph()

for i in arr:
  tmp = i.split(",")
  G.add_edge(*(tmp[0], tmp[1]))

fig = pylab.figure()
fig.set_facecolor("#ffffff")

c = nx.degree_centrality(G)
nx.draw(G,
  alpha=.5,

  # font style
  # font_weight="800",
  font_size=10,
  font_color="#000000",

  #node style
  node_color='#00ff00',
  edge_color='#607d8b',
  node_size=[(c[n]+0.00001)*5000 for n in G.nodes()], #TO DO fare una "normalizzazione" dei valori
  cmap=pylab.cm.Blues,
  with_labels=True)

nx.write_gpickle(G, "myplot.gpickle")
#plt.show()
