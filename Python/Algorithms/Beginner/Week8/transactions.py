import threading
import time

current_balance = 1000

def pay_bill(num):
    global current_balance
    current_balance = current_balance - num;
    print("current balance: ", current_balance)
    time.sleep(0.9)

def deposit_profit(num):
    global current_balance
    current_balance = current_balance + num;
    print("current balance: ", current_balance)
    time.sleep(0.9)

def main():
    global current_balance
    t1 = threading.Thread(target=deposit_profit, args=(100,))
    t2 = threading.Thread(target=pay_bill, args=(100,))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print("current balance: ", current_balance)

main()