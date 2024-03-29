import matplotlib.pyplot as plt
import pandas as pd

def graphs():
    df1 = pd.read_csv("assets/output_data_one_thread.txt", delimiter=" ")
    df1Temp = pd.read_csv("assets/output_data_one_thread_temp.txt", delimiter=" ")
    df5 = pd.read_csv("assets/output_data_five_threads.txt", delimiter=" ")
    df5Temp = pd.read_csv("assets/output_data_five_threads_temp.txt", delimiter=" ")
    df10 = pd.read_csv("assets/output_data_ten_threads.txt", delimiter=" ")
    df10Temp = pd.read_csv("assets/output_data_ten_threads_temp.txt", delimiter=" ")

    plt.plot(df1Temp.values[:100], color='red', label='1 Thread')
    plt.plot(df5Temp.values[:100], color='green', label='5 Threads')
    plt.plot(df10Temp.values[:100], color='blue', label='10 Threads')
    plt.show()

if __name__ == '__main__':
    graphs()