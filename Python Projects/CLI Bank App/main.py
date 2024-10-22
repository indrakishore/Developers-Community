# banking system

#Extra Info
from operator import index
import mysql

print("\n\nWelcome To The Bank")

#User Commands
commands = ["1. Create A New Account" , "2. Check Account Balance" , "3. Add Money" , "4. Withdraw Money"]
print("\n\nPleasse Select A Valid Command From The Below Listed Commands :- ")
print(commands)

all_Accounts = []
account_Number = []
amounts = []

for i in range (10):
    amounts.append(0)

#New Account Creation Function
def new_account():
    account_name = input("Please Input The Name Of The Account Holder : ")
    phone_number = int(input("Please Input Your Mobile Number: "))
    
    all_Accounts.append(account_name)


    print(f"{account_name} Congratulations!! Your Account Has Been Successfully Created!!!")
    print("Please Deposit Some Money In Your Account To Validate It")
    print("Account Number Is " + f"111{phone_number}00{all_Accounts.index(account_name)}")

    true_number = int(f"111{phone_number}00{all_Accounts.index(account_name)}")
    account_Number.append(true_number)
    print(true_number)

# Money Addition Function
def add_money():
    number_to_add = int(input("Please Input Your Account No: "))

    if number_to_add in account_Number:

        print("Verified Account")
        amount_Of_Money = int(input("Please Enter The Amount The Add Money: "))
        i = account_Number.index(number_to_add)
        current_Available_Amount = amounts.__getitem__(i)
        amounts[i] = current_Available_Amount+amount_Of_Money
        print(f"Your Account Balance Is {amounts.__getitem__(i)} Rupees")
    else:
        print("Error! Account Not Found , Please Create Your Account First!")

#Account Balance Checking Function
def check_balance():
    account_Number_ToCheckBalance = int(input("Please Input your Account NO. To check Balance: "))
    
    if account_Number_ToCheckBalance in account_Number:

        print("Verified Account")

        j = account_Number.index(account_Number_ToCheckBalance)
        Current_Ammount = amounts.__getitem__(j)
        print("Your Current Balance Is : " + str(Current_Ammount) + "Rupees")

#Money Withdrawing Function
def withdraw_Money():

    number_to_withdraw = int(input("Please Input Your Account No: "))

    if number_to_withdraw in account_Number:

        print("Verified Account")
        amount_Of_Money = int(input("Please Enter The Amount To  Withdraw Money: "))
        k = account_Number.index(number_to_withdraw)
        current_Available_Amount = amounts.__getitem__(k)
        amounts[k] = current_Available_Amount-amount_Of_Money
        print(f"Your Account Balance Is {amounts.__getitem__(k)} Rupees")
    else:
        print("Error! Account Not Found , Please Create Your Account First!")


#True Loop for user Experience
while True:
    user_command = int(input("\nPlease Enter The Command Number To Select The Command : "))
    
    if user_command == 1:
        print("Processing Request")
        new_account()

    elif user_command == 2:
        print("Processing Request")
        check_balance()
        

    elif user_command == 3:
        print("Processing Request")
        add_money()

    elif user_command == 4:
        print("Processing Request")
        withdraw_Money()

    elif user_command >=5 or user_command!=1 or 2 or 3 or 4 :
        print("\nPlease Select A Valid Command Number From 1 To 4")
        print(commands)

# Master Check
    elif user_command == 1235:
        print("Hello Sir")
        print("Here Is Data")

        print(all_Accounts)
        print(account_Number)
        print(amounts)