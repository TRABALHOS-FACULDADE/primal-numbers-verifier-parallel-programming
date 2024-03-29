import matplotlib.pyplot as plt
import pandas as pd

def graphs():
    df1Temp = pd.read_csv("assets/output_data_one_thread_temp.txt", delimiter=" ")
    df5Temp = pd.read_csv("assets/output_data_five_threads_temp.txt", delimiter=" ")
    df10Temp = pd.read_csv("assets/output_data_ten_threads_temp.txt", delimiter=" ")

    fig, axs = plt.subplots(1, 3)
    fig.subplots_adjust(left=0.2, wspace=0.6)

    axs[0].plot(df1Temp.values[:100], color='red')
    axs[0].set_title('1 Thread')
    axs[1].plot(df5Temp.values[:100], color='green')
    axs[1].set_title('5 Threads')
    axs[2].plot(df10Temp.values[:100], color='blue')
    axs[2].set_title('10 Threads')
    plt.show()

if __name__ == '__main__':
    graphs()