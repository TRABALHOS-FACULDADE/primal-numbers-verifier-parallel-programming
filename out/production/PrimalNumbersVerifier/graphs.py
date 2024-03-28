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
    print(df1.values.reshape(1, 1).tolist())
    concat = np.array([df1.values.reshape(1, 1), df5.values.reshape(1, 1), df10.values.reshape(1, 1)])
    lista = np.unique(concat)
    plt.plot(df1Temp.values, lista)
    plt.plot(df5Temp.values, lista)
    plt.plot(df10Temp.values, lista)
    plt.show()

if __name__ == '__main__':
    graphs()