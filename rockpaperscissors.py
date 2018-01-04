# imports:
from random import randint


##
#
# Author: Trevor Dick
##

# prints title of game
print("Rock, Paper, Scissors")

# game prompt to input choice
player = input('player choose: rock (r) , paper (p) , scissors (s)')

# setting up random computer choice
comp = randint(1,3)
if comp == 1:
    computer = 'r'
elif comp == 2:
    computer = 'p'
else:
    computer = 's'

# display chioces made by each player
print('Player chooses:' , player , 'Computer chooses:' , computer)




# function to check if the player is a winner or not
def check( ):

    #Draw case
    if player == computer:
        print('TIES')
    #Player win cases
    elif player == 'r' and computer == 's':
        return 'WINS!'
    elif player == 'p' and computer == 'r':
        return 'WINS!'
    elif player == 's' and computer == 'p':
        return 'WINS!'
    #Computer win cases
    else:
        return 'LOOSES, play again? ...'
   
print('Player' , check())
    
