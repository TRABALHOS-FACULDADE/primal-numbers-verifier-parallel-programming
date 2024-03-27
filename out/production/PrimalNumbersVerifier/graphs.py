import matplotlib.pyplot as plt
import pandas as pd

def graphs():
    df = pd.read_csv("assets/output_data_ten_threads.txt", delimiter=" ")
    plt.plot(df.values)
    plt.show()

if __name__ == '__main__':
    graphs()