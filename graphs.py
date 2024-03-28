import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

def graphs():
    df1 = pd.read_csv("assets/output_data_one_thread.txt", delimiter=" ")
    df1Temp = pd.read_csv("assets/output_data_one_thread_temp.txt", delimiter=" ")
    df5 = pd.read_csv("assets/output_data_five_threads.txt", delimiter=" ")
    df5Temp = pd.read_csv("assets/output_data_five_threads_temp.txt", delimiter=" ")
    df10 = pd.read_csv("assets/output_data_ten_threads.txt", delimiter=" ")
    df10Temp = pd.read_csv("assets/output_data_ten_threads_temp.txt", delimiter=" ")

    concat = np.concatenate((df1.values, df5.values, df10.values))
    lista = np.unique(concat)

    concatTemp = np.concatenate((df1Temp.values, df5Temp.values, df10Temp.values))
    plt.plot(concatTemp[:2437], lista)
    plt.show()

if __name__ == '__main__':
    graphs()